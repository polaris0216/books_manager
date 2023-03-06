package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//セキュリティからの除外設定
	@Override
	// WebSecurity型の引数を持ったconfigure()を追加します
	public void configure(WebSecurity web) throws Exception {
		/** 以下のファイルパス配下のディレクトリ、ファイルすべてを認証・認可の対象から除外します
		    src/main/resources/static/css/
		    src/main/resources/static/js/
		    src/main/resources/static/images/
		*/
		web.ignoring().antMatchers("/css/**", "/js/**", "/images/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 認証・認可に関する設定を追加します
		// 認可の設定
		http.authorizeRequests()
				.antMatchers("/loginForm").permitAll() // /loginFormは、全ユーザからのアクセスを許可
				//.antMatchers("/admin").hasAuthority("ADMIN") // 管理者のみ/adminにアクセスできる
				.anyRequest().authenticated(); // 許可した項目以外は、認証を求める

		   //ログイン処理
        http.formLogin()
            .loginProcessingUrl("/login") // ログイン処理のパス
            .loginPage("/loginForm") // ログインページの指定。このページに設置したフォームがloginProcessingUrlへPOSTリクエストします。

            //usernameParameterとpasswordParameterは
            //ログインフォームから送られてくるユーザー名とパスワードのパラメータ名を指定します。
            //<input>タグのname属性とこれらの引数を合わせる必要があります。
            .usernameParameter("email") // ログインページのメールアドレス
            .passwordParameter("password") // ログインページのパスワード

            //第1引数には認証が成功したときの遷移先を指定します。
            //第2引数がtrueの場合は、認証成功後に第1引数のパスに遷移します。
            .defaultSuccessUrl("/home", true) // ログイン成功後のパス
            .failureUrl("/loginForm?error"); // ログイン失敗時のパス
	}

	//パスワードのエンコードにはBCryptPasswordEncoderを利用
	// ハッシュアルゴリズムの定義
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
