# Foremについて
    ForemはAndroid Studioの開発を円滑に進めるためのJavaライブラリです。


# 特徴
    通常のAndroid Studioでは、レイアウトをXML、処理をJavaで記述していましたが、
    Foremを使用することで、Javaのみでレイアウトと処理を同時に記述することが可能になります。


# ダウンロード
    Foremを使用するプロジェクトのapp -> java -> com.exmaple.[プロジェクト名]フォルダ内に
    当フォルダを配置してください。


# 開発準備
    1.Foremを使用するアクティビティにForemインタフェースを実装してください
    例:
  #                                                         //   該当箇所   //
        public class MainActivity extends AppCompatActivity implements Forem{

        }

    2.Foremインタフェースを実装したクラスにrenderメソッドを定義してください。
    renderメソッドのアクセス修飾子はpublic,戻り値はvoid,引数なしで
    Foremインタフェースで抽象メソッドとして定義されています。
    そのため、正確にはオーバーライドを行う形になっています。
    例:
        public class MainActivity extends AppCompat implements Forem{
            ... 別の処理 ...

  #         // 該当箇所 //
            public void render(){
                
            }
        }

    3.[2]で定義したrenderメソッドをonCreateメソッド内で呼び出してください。
    例:
        public class MainActivity extends AppCompat implements Forem{
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
  #            // 該当箇所 //
                this.render();
            }
            
            public void render(){
                
            }
        }

  # 以上の記述で、Foremを使用するための準備は終了となります。
  # また、レイアウトやレイアウトに関連する処理はrenderメソッド内に記述していきます。


# 使い方
  # Rootの作成
    renderメソッド内に以下のコードを記述します。
    Root().render(()->{
   # [レイアウト処理]
    });
   上記は、画面を作成する処理になっています。
    一般的に[レイアウト処理]部分にレイアウトを記述していきます。

  # 要素の表示(TextView)
    TextViewを表示する処理を記述していきます。
    [レイアウト処理]部分に以下のコードを記述します。
    this.<TextView>create(textView)
    上記のコードを記述することで、rootを親としたTextView要素を作成します。

    続いて、作成したTextView要素を表示していきます。
    this.<TextView>create(textView->{
        
    });
    上記のコードを記述することで、root配下にTextView要素を表示します。
    また、createメソッド内で記述しているtextView変数は
    先ほど作成したTextView要素のインスタンスが格納されています。
    しかし、widthやheight、表示する文字列を指定していないため、視覚的には何も表示されません。

    次に、要素に属性を付与し、視覚的に表示していきます。
    this.<TextView>create(textView->{
        layout(textView,wrap_content,wrap_content);
        textView.setText("ForemText");
    });
    layoutメソッドは(要素,width,height)の順番で値を渡すことで、要素に属性を付与できます。
    また、4つ目の引数としてweightを指定することもできます。
    textView変数はTextViewクラスのインスタンスのため、当ファイルでの説明は省略します。
    要素への属性付与方法はAndroid Studioなどのドキュメントを参照してください。

  # 要素の表示(Button)
    TextViewとほとんど同じですが、Buttonを表示する処理も記述していきます。
    [レイアウト処理]部分に以下のコードを記述します。
    this.<Button>create(button)
    上記のコードを記述することで、rootを親としたButton要素を作成します。

    続いて、作成したButton要素を表示していきます。
    this.<Button>create(button->{
        
    });
    上記のコードを記述することで、root配下にButton要素を表示します。
    また、createメソッド内で記述しているButton変数は
    先ほど作成したButton要素のインスタンスが格納されています。
    しかし、widthやheight、表示する文字列を指定していないため、視覚的には何も表示されません。

    次に、要素に属性を付与し、視覚的に表示していきます。
    this.<Button>create(button->{
        layout(button,wrap_content,wrap_content);
        button.setText("ForemButton");
        button.setOnClickListener(v->{
            button.setText("ForemButton Clicked");
        });
    });
    button変数はButtonクラスのインスタンスのため、当ファイルでの説明は省略します。
    要素への属性付与方法はAndroid Studioなどのドキュメントを参照してください。

  # 要素の表示(LinearLayout)
    LinearLayoutを作成し、その中にTextViewとButtonを表示する処理を記述していきます。
    [レイアウト処理]部分に以下のコードを記述します。
    this.<LinearLayout>create(linearLayout->{
        layout(linearLayout,wrap_content,wrap_content);
        linearLayout.setBackgroundColor(Color.RED);
    })

    TextViewやButtonを表示した際に行った処理と、linearLayoutの範囲をわかりやすくするために
    linearLayoutの背景色を赤にする処理を記述しています。

    次に現在作成したlinearLayout配下にTextView要素を記述していきます。
    this.<LinearLayout>create(linearLayout->{
        layout(linearLayout,wrap_content,wrap_content);
        linearLayout.setBackgroundColor(Color.RED);
    }).render(linearLayout->{
        this.<TextView>of(linearLayout).attribute(linearTextView->{
            layout(linearTextView,wrap_content,wrap_content);
            linearTextView.setText("ForemLinearText");
        });
        this.<Button>of(linearLayout).attribute(linearButton->{
            layout(linearButton,wrap_content,wrap_content);
            linearButton.setText("ForemLinearButton");
            linearButton.setOnClickListener(v->{
                linearButton.setText("ForemLinearButton Clicked"));
            });
        });
    });
    上記のように、ViewGroupと呼ばれるLinearLayoutなどの要素に限り、
    createメソッドの後ろにrenderメソッドを呼び出すことで、
    そのLinearLayoutの中のレイアウトを記述することができます。


# クラス・メソッド説明・使用例




# デモ開発
    上記の説明で理解できた方には必要ないかもしれませんが、
    理解が難しかった方や手を動かして理解を深めたい方は、Forem使って簡単なアプリを作ってみましょう。

    // ToDoアプリにするか？それともサンプルコードにするか。