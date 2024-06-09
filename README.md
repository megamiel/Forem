# Forem

"Forem"はAndroid Studioでの開発の際に、レイアウトと処理の記述を同時に行うことができるJavaライブラリです。  
このライブラリを使用することで、従来のレイアウトをXMLファイルに記述し、処理をJavaまたはKotlinファイルに記述する方法と比較して、開発の効率性と可読性を向上させることができます。


# 特徴
レイアウトと処理を同時に記述 : レイアウトとイベント処理を同時に記述することで、コードの可読性が向上します。  
簡潔なコード : XMLファイルを使用しないため、コードがシンプルになり、保守が容易になります。


# 普通に開発した場合との比較
レイアウトをXML,処理をJavaで記述した場合のサンプルコードと、Foremを使用して記述した場合のサンプルコードを示します。  
以下のサンプルコードはどちらもボタンがクリックされると、テキストが[NOT CLICKED]から[CLICKED]に変更されるプログラムです。


## レイアウトをXML,処理をJavaで記述した場合のサンプルコード

### XMLでのレイアウト記述
```XML

<?xml version="1.0" encoding="utf-8"?>
<androidx.appcompat.widget.LinearLayoutCompat
    xmlns:android="http://schemas.android.com/apk/res/android" android:layout_width="match_parent"
    android:layout_height="match_parent" android:orientation="vertical" android:weightSum="100">

    <!--  [Point1]  -->
    <Space 
        android:layout_width="0dp" 
        android:layout_height="0dp"
        android:layout_weight="10" />

    <!--  [Point2]  -->
    <TextView
        android:id="@+id/textId"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="30" 
        android:text="NOT CLICKED"
        android:textSize="32dp"
        android:gravity="center" />

    <!--  [Point3]  -->
    <Space
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_weight="10" />

    <!--  [Point4]  -->
    <Button 
        android:id="@+id/buttonId"
        android:layout_width="match_parent"
        android:layout_height="0dp" 
        android:layout_weight="20"
        android:text="BUTTON"
        android:textSize="32dp"
        android:textColor="@color/white"
        android:backgroundTint="@color/black" />

</androidx.appcompat.widget.LinearLayoutCompat>

```

### Javaでの処理記述
```Java

public class SampleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textId);
        Button button = findViewById(R.id.buttonId);
        // [Point5]
        button.setOnClickListener(v -> {
            textView.setText("CLICKED");
        });
    }
}

```






# Foremを使用して記述した場合のサンプルコード

```Java

public class MainActivity extends ForemActivity {
    @Override
    public void render(Root root) {
        // [Point1]
        // 順に、width,height,weightを表しています
        space(0, 0, 10);

        // TextViewクラスの変数を定義
        var textView = varType(TextView.class);

        // [Point2]
        // TextViewのレイアウトを作成。同時に、textView変数に、作成したTextViewのインスタンスを代入
        this.<TextView>create(textView, () -> {
            // 順に、width,height,weightを表しています
            layout(match_parent, 0, 30);
            text("NOT CLICKED");
            textSize(32);
            alignCenter();
        });

        // [Point3]
        space(0, 0, 10);

        // [Point4]
        // Buttonのレイアウトを作成。クリックされた際の処理も同時に記述
        this.<Button>create(() -> {
            layout(match_parent, 0, 20);
            text("BUTTON");
            textSize(32);
            textColor(Color.WHITE);
            backgroundColor(Color.BLACK);
            // [Point5]
            onClick(() -> {
                // get(textView)によって、textViewに格納されているTextViewクラスのインスタンスを取得し、
                // 取得したインスタンスのsetTextメソッドを呼び出している。
                get(textView).setText("CLICKED");
            });
        });

    }
}

```


# 実装方法
