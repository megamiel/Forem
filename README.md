# Forem

"Forem"はAndroid Studioでの開発の際に、レイアウトと処理の記述を同時に行うことができるJavaライブラリです。  
このライブラリを使用することで、従来のレイアウトをXMLファイルに記述し、処理をJavaまたはKotlinファイルに記述する方法と比較して、開発の効率性と可読性を向上させることができます。


## 特徴
レイアウトと処理を同時に記述 : レイアウトとイベント処理を同時に記述することで、コードの可読性が向上します。  
簡潔なコード : XMLファイルを使用しないため、コードがシンプルになり、保守が容易になります。

## 実装方法
1. Foremを実装したいプロジェクトをAndroid Studioで開きます。(注意:プロジェクトのロードが終わるまで次の手順を行わないでください)
2. ターミナルを起動し、以下のコマンドを実行します。
    ```bash
    git clone https://github.com/megamiel/Forem.git
    ```
3. `setting.gradle`を開き、以下の行を追加します。
    ```gradle
    include ':Forem'
    ```
4.`build.gradle(Module:app)`を開き、該当箇所のバージョンが下記以上であることを確認してください。
```gradle
android {
    compileSdk 34
    defaultConfig {
        targetSdk 34
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_10
        targetCompatibility JavaVersion.VERSION_1_10
    }
}
```
5. `build.gradle(Module:app)`に、以下の行を追加します。
    ```gradle
    implementation project(path: ':Forem')
    ```
6. Sync Nowをクリックしてプロジェクトを同期すると、実装完了となります。


## 使い方
詳細な使い方は[こちら](https://github.com/megamiel/Forem/tree/master/docs/api/overview.md)を参照してください。


## サンプルコード比較
レイアウトをXML, 処理をJavaで記述した場合のサンプルコードと、Foremを使用して記述した場合のサンプルコードを用意しました。  
以下のサンプルコードはどちらもボタンがクリックされると、テキストが[NOT CLICKED]から[CLICKED]になるプログラムです。

---
### レイアウトをXML, 処理をJavaで記述した場合のサンプルコード

#### activity_main.xml
```XML

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/buttonId"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:text="NOT CLICKED" />

</LinearLayout>

```

#### MainActivity.java
```Java

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){

        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        // idからボタン要素を取得
        Button button=findViewById(R.id.buttonId);
        // クリックされた際のイベント処理を記述
        button.setOnClickListener(v->{
            button.setText("CLICKED");
        });

    }
}

```
---

### Foremを使用して記述した場合のサンプルコード

#### MainActivity.java
```Java

public class MainActivity extends ForemActivity {
    @Override
    public void render(Root root) {

        // ボタン要素を作成
        this.<Button>create(() -> {
            // 左から順に、width, heightを指定
            layout(match_parent, match_parent);
            text("NOT CLICKED");
            // クリックされた際のイベント処理を記述
            onClick(() -> {
                text("CLICKED");
            });
        });

    }
}

```
---


お気軽に質問やフィードバックをお寄せください
