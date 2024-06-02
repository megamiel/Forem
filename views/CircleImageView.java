// import文は省略しています

// 注記:画像ファイルのみ設定可能です
@SuppressLint("AppCompatCustomView")
public class CircleImageView extends ImageView {
    private int canvasSize;
    private Paint paint;

    public CircleImageView(Context context) {
        super(context, null);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        BitmapDrawable drawable = (BitmapDrawable) getDrawable();
        if (drawable == null)
            return;
        if (getWidth() == 0 || getHeight() == 0)
            return;

        Bitmap srcBmp = drawable.getBitmap();
        if (srcBmp == null)
            return;

        Bitmap image = getSquareBitmap(srcBmp);

        canvasSize = canvas.getWidth();
        if (canvas.getHeight() < canvasSize)
            canvasSize = canvas.getHeight();

        BitmapShader shader =
                new BitmapShader(Bitmap.createScaledBitmap(image, canvasSize, canvasSize, false),
                        Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        int circleCenter = canvasSize / 2;
        canvas.drawCircle(circleCenter, circleCenter, circleCenter - 1, paint);
    }

    private Bitmap getSquareBitmap(Bitmap srcBmp) {
        if (srcBmp.getWidth() == srcBmp.getHeight())
            return srcBmp;

        // Rectangle to square. Equivarent to ScaleType.CENTER_CROP
        int dim = Math.min(srcBmp.getWidth(), srcBmp.getHeight());
        Bitmap dstBmp = Bitmap.createBitmap(dim, dim, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(dstBmp);
        float left = srcBmp.getWidth() > dim ? (dim - srcBmp.getWidth()) / 2 : 0;
        float top = srcBmp.getHeight() > dim ? ((dim - srcBmp.getHeight()) / 2) : 0;
        canvas.drawBitmap(srcBmp, left, top, null);

        return dstBmp;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int measureWidth(int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            // The parent has determined an exact size for the child.
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            // The child can be as large as it wants up to the specified size.
            result = specSize;
        } else {
            // The parent has not imposed any constraint on the child.
            result = canvasSize;
        }

        return result;
    }

    private int measureHeight(int measureSpecHeight) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpecHeight);
        int specSize = MeasureSpec.getSize(measureSpecHeight);

        if (specMode == MeasureSpec.EXACTLY) {
            // We were told how big to be
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            // The child can be as large as it wants up to the specified size.
            result = specSize;
        } else {
            // Measure the text (beware: ascent is a negative number)
            result = canvasSize;
        }

        return (result + 2);
    }
}
