// import文は省略しています

public abstract class ForemActivity extends AppCompatActivity implements Forem {
    @Override
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Root().render(this::render);
    }
}
