package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Library;
import com.example.entity.Logs;
import com.example.service.LibraryService;
import com.example.service.LoginUser;
import com.example.service.LogsService;

@Controller
@RequestMapping("/library")
public class LibraryController {

	private final LibraryService libraryService;
	private final LogsService logsService;

	@Autowired
	public LibraryController(LibraryService libraryService, LogsService logsService) {
		this.libraryService = libraryService;
		this.logsService = logsService;
	}

	@GetMapping
	public String index(Model model) {
		List<Library> libraries = this.libraryService.findAll();
		model.addAttribute("libraries", libraries);
		return "library/index";
	}

	@GetMapping("borrow") //書籍貸し出しフォームを表示する
	public String borrowingForm(@RequestParam("id") Integer id, Model model) {
		Library library = this.libraryService.findLibrary(id);
		model.addAttribute("library", library);
		return "library/borrowingForm";
	}


	@GetMapping("history") //貸し出し履歴を取得し、表示する
	public String history(Model model, @AuthenticationPrincipal LoginUser loginUser) {
		//ログインユーザーIDを利用してLogモデルからこれまでの貸出履歴を取得
		List<Logs> logs = logsService.findByUserId(loginUser.getUser().getId());
		model.addAttribute("logs", logs);
		//取得した履歴情報をModelクラスのaddAttributeめどっそを利用してborrowHistory.htmlに渡して表示
		return "library/borrowHistory";
	}

	@PostMapping("borrow") //貸出しフォームの情報をもとに、貸出し処理を行う
	public String borrow(@RequestParam("id") Integer id, @RequestParam("return_due_date") String returnDueDate,
			@AuthenticationPrincipal LoginUser loginUser) {

		//ログイン中のIDを受け取ってLIBRARIESテーブルのUSER＿IDに更新
		this.libraryService.insert(id, returnDueDate, loginUser);
		this.logsService.insert(id, returnDueDate, loginUser);
		//Logsモデルを利用して LIBRARY_ID, USER_ID, RENT_DATE, RETURN_DUE_DATEにデータ入力
		//Logs logs = this.logsService.save(id,)
		return "redirect:/library";
	}

	@PostMapping("return") //受け取った書籍IDをもとに返却処理を行う
	public String returnBook(@RequestParam("id") Integer id, @AuthenticationPrincipal LoginUser loginUser) {
		//書籍情報を1件取得し代入する。
		//取得した書籍情報のUSER_IDに0セット
		this.libraryService.returnBook(id);
		//Logsモデルを利用してupdate処理を行う(LIBRARY_ID, USER_IDで対象検索)
		this.logsService.update(id, loginUser);
		//redirect機能を利用して/libraryにリダイレクト
		return "redirect:/library";
	}

}