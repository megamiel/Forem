# Forem

"Forem"はAndroid Studioでの開発の際に、レイアウトと処理の記述を同時に行うことができるJavaライブラリです。  
このライブラリを使用することで、従来のレイアウトをXMLファイルに記述し、処理をJavaまたはKotlinファイルに記述する方法と比較して、開発の効率性と可読性を向上させることができます。


# 特徴
レイアウトと処理を同時に記述 : レイアウトとイベント処理を同時に記述することで、コードの可読性が向上します。  
簡潔なコード : XMLファイルを使用しないため、コードがシンプルになり、保守が容易になります。


# 実装方法
1. Foremを実装したいプロジェクトをAndroid Studioで開きます。
2. ターミナルを起動し、以下のコマンドを実行します。
    ```bash
    git clone https://github.com/megamiel/Forem.git
    ```
3. setting.gradleを開き、include ':Forem'を記述し、Sync Nowをクリックします。
4. MainActivity.javaを開き、extends AppCompatActivityの部分をextends ForemActivityに変更します。
5. ForemActivityが赤くなるため、カーソルを合わせ、「'モジュール[プロジェクト名].Forem.mainに依存関係を追加'」を選択し、gradleの更新が行われば実装完了です。
6. クラスのインポートなどを随時行ってください。



# サンプルコード比較
レイアウトをXML,処理をJavaで記述した場合のサンプルコードと、Foremを使用して記述した場合のサンプルコードを示します。  
以下のサンプルコードはどちらもボタンがクリックされると、テキストが[NOT CLICKED]から[CLICKED]になるプログラムです。


## レイアウトをXML,処理をJavaで記述した場合のサンプルコード


### XMLでのレイアウト記述
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

### Javaでの処理記述
```Java

public class SampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle){

        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.buttonId);
        button.setOnClickListener(v->{
            button.setText("CLICKED");
        });

    }
}

```






## Foremを使用して記述した場合のサンプルコード

```Java

public class MainActivity extends ForemActivity {
    @Override
    public void render(Root root) {

        // ボタン要素を作成
        this.<Button>create(() -> {
            // 左から順に、width,heightを指定しています
            layout(match_parent, match_parent);
            text("NOT CLICKED");
            // クリックされた際のイベント処理が記述できます
            onClick(() -> {
                text("CLICKED");
            });
        });

    }
}

```

