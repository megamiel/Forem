# Foremについて
  ForemとはAndroid Studioの開発を円滑に進めるためのJavaライブラリです。
  
# 概要
  通常のAndroid Studioでは、レイアウトをXML、処理をJavaで記述していましたが、 
  Foremを使用することで、レイアウトと処理をJavaで完結させることができます。
  

# Javaバージョンの更新
  build.gradle(:app)の該当箇所を以下のように書き換えてください
  compileOptions { 
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
  }

# 実装方法
  1.Foremを使用するアクティビティにForemインタフェースを実装してください
  例:
#                                                     //   該当箇所   //
  public class MainActivity extends AppCompatActivity implements Forem{
  
  }
