package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Library;
import com.example.repository.LibraryRepository;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    @Autowired
    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<Library> findAll() {
        return this.libraryRepository.findAll();
    }

    public Library findLibrary(Integer libraryId) {
    	// データの1件取得
        Optional<Library> optionalLibrary = this.libraryRepository.findById(libraryId);
        // OptionalからEntityクラスの取得を試みる
        Library library = optionalLibrary.get();
        return library;
    }

//	public Library findById(Integer id) {
//		Optional<Library> optionalLibrary = this.libraryRepository.findById(id);
//		Library library = optionalLibrary.get();
//		// TODO 自動生成されたメソッド・スタブ
//		return library;
//	}

    public Library insert(Integer id,  String returnDueDate, LoginUser loginUser) {
    	// データ１件分のEntityクラスを取得します
    	Optional<Library> optionalLibrary  = this.libraryRepository.findById(id);
    	Library library = optionalLibrary.get();
    	library.setUserId(loginUser.getId());
		return this.libraryRepository.save(library);
    }

    //LibraryControllerのreturnBook.returnBook処理
    public Library returnBook(Integer id) {
    	//書籍情報を1件取得し代入する。
    	Optional<Library>optionalLibrary = this.libraryRepository.findById(id);
    	Library library = optionalLibrary.get();
    	library.setUserId(0);
    	return this.libraryRepository.save(library);
    }



}