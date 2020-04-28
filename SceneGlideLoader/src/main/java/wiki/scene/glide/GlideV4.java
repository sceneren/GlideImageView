package wiki.scene.glide;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import com.sunfusheng.glideimageview.R;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import wiki.scene.glide.config.GlideConfigImpl;
import wiki.scene.glide.progress.EasyGlideApp;
import wiki.scene.glide.progress.GlideImageViewTarget;
import wiki.scene.glide.progress.GlideRequest;
import wiki.scene.glide.progress.GlideRequests;
import wiki.scene.glide.progress.OnProgressListener;
import wiki.scene.glide.progress.ProgressManager;

public class GlideV4 {
    public static int placeHolderImageView = R.color.transparent;
    public static int circlePlaceholderImageView = R.color.transparent;


    public static void loadImage(Context context, String url, ImageView imageView) {
        loadImage(context, url, imageView, placeHolderImageView, null, null, true);
    }

    public static void loadImage(Context context, String url, ImageView imageView, boolean isCenterCrop) {
        loadImage(context, url, imageView, placeHolderImageView, null, null, isCenterCrop);
    }

    public static void loadImage(Context context, String url, ImageView imageView, RequestListener requestListener) {
        loadImage(context, url, imageView, placeHolderImageView, null, requestListener, true);
    }

    public static void loadImage(Context context, String url, ImageView imageView, RequestListener requestListener, boolean isCenterCrop) {
        loadImage(context, url, imageView, placeHolderImageView, null, requestListener, isCenterCrop);
    }

    public static void loadImage(Context context, String url, ImageView imageView, OnProgressListener onProgressListener) {
        loadImage(context, url, imageView, placeHolderImageView, onProgressListener, null, true);
    }

    public static void loadImage(Context context, String url, ImageView imageView, OnProgressListener onProgressListener, boolean isCenterCrop) {
        loadImage(context, url, imageView, placeHolderImageView, onProgressListener, null, isCenterCrop);
    }

    public static void loadImage(Context context, String url, ImageView imageView, @DrawableRes int placeHolder) {
        loadImage(context, url, imageView, placeHolder, null, null, true);
    }

    public static void loadImage(Context context, String url, ImageView imageView, @DrawableRes int placeHolder, boolean isCenterCrop) {
        loadImage(context, url, imageView, placeHolder, null, null, isCenterCrop);
    }

    public static void loadImage(Context context, String url, ImageView imageView, @DrawableRes int placeHolder, OnProgressListener onProgressListener, RequestListener requestListener, boolean isCenterCrop) {
        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .url(url)
                        .isCropCenter(isCenterCrop)
                        .isCrossFade(false)
                        .errorPic(placeHolder)
                        .placeholder(placeHolder)
                        .imageView(imageView)
                        .progressListener(onProgressListener)
                        .requestListener(requestListener)
                        .build());
    }

    public static void loadGifImage(Context context, String url, ImageView imageView) {
        loadGifImage(context, url, imageView, placeHolderImageView, null, null);
    }

    public static void loadGifImage(Context context, String url, ImageView imageView, RequestListener requestListener) {
        loadGifImage(context, url, imageView, placeHolderImageView, null, requestListener);
    }

    public static void loadGifImage(Context context, String url, ImageView imageView, OnProgressListener onProgressListener) {
        loadGifImage(context, url, imageView, placeHolderImageView, onProgressListener, null);
    }

    public static void loadGifImage(Context context, String url, ImageView imageView, @DrawableRes int placeHolder) {
        loadGifImage(context, url, imageView, placeHolder, null, null);
    }

    public static void loadGifImage(Context context, String url, ImageView imageView, @DrawableRes int placeHolder, OnProgressListener onProgressListener, RequestListener requestListener) {
        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .url(url)
                        .isCrossFade(false)
                        .errorPic(placeHolder)
                        .placeholder(placeHolder)
                        .imageView(imageView)
                        .progressListener(onProgressListener)
                        .requestListener(requestListener)
                        .build());
    }

    public static void loadResizeXYImage(Context context, String url, int resizeX, int resizeY, ImageView imageView) {
        loadResizeXYImage(context, url, resizeX, resizeY, imageView, placeHolderImageView);
    }

    /**
     * 加载本地图片
     *
     * @param context
     * @param drawableId
     * @param resizeX
     * @param resizeY
     * @param imageView
     */
    public static void loadResizeXYImage(Context context, @RawRes @DrawableRes @Nullable Integer drawableId, int resizeX, int resizeY, ImageView imageView) {
        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .drawableId(drawableId)
                        .isCropCenter(true)
                        .resize(resizeX, resizeY)
                        .imageView(imageView)
                        .build());
    }

    public static void loadResizeXYImage(Context context, String url, int resizeX, int resizeY, ImageView imageView, @DrawableRes int placeHolder) {
        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .url(url)
                        .isCropCenter(true)
                        .isCrossFade(false)
                        .resize(resizeX, resizeY)
                        .errorPic(placeHolder)
                        .placeholder(placeHolder)
                        .imageView(imageView)
                        .build());
    }


    public static void loadCircleImage(Context context, String url, ImageView imageView) {
        loadCircleImage(context, url, imageView, circlePlaceholderImageView);
    }

    public static void loadCircleImage(Context context, String url, ImageView imageView, @DrawableRes int placeHolder) {
        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .url(url)
                        .isCropCircle(true)
                        .isCrossFade(false)
                        .errorPic(placeHolder)
                        .placeholder(placeHolder)
                        .imageView(imageView)
                        .build());
    }


    public static void loadBlurImage(Context context, String url, ImageView imageView) {
        loadBlurImage(context, url, 10, imageView, placeHolderImageView);
    }

    public static void loadBlurImage(Context context, String url, int radius, ImageView imageView) {
        loadBlurImage(context, url, radius, imageView, placeHolderImageView);
    }

    public static void loadBlurImage(Context context, String url, int radius, ImageView imageView, @DrawableRes int placeHolder) {
        MultiTransformation<Bitmap> multi = new MultiTransformation<>(new CenterCrop(), new BlurTransformation(radius));
        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .url(url)
                        .apply(RequestOptions.bitmapTransform(multi))
                        .isCrossFade(false)
                        .errorPic(placeHolder)
                        .placeholder(placeHolder)
                        .imageView(imageView)
                        .build());
    }


    public static void loadRoundCornerImage(Context context, String url, ImageView imageView) {
        loadRoundCornerImage(context, url, 40, 0, imageView, placeHolderImageView);
    }

    public static void loadRoundCornerImage(Context context, String url, int radius, int margin, ImageView imageView) {
        loadRoundCornerImage(context, url, radius, margin, imageView, placeHolderImageView);
    }

    public static void loadRoundCornerImage(Context context, String url, int radius, int margin, ImageView imageView, @DrawableRes int placeHolder) {
        MultiTransformation<Bitmap> multi = new MultiTransformation<>(new CenterCrop(), new RoundedCornersTransformation(radius, margin));

        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .url(url)
                        .apply(RequestOptions.bitmapTransform(multi))
                        .isCrossFade(false)
                        .errorPic(placeHolder)
                        .placeholder(placeHolder)
                        .imageView(imageView)
                        .build());
    }

    public static void loadCircleWithBorderImage(Context context, String url, ImageView imageView) {
        loadCircleWithBorderImage(context, url, 2, Color.parseColor("#ACACAC"), imageView, placeHolderImageView);
    }

    public static void loadCircleWithBorderImage(Context context, String url, int borderWidth, @ColorInt int borderColor, ImageView imageView) {
        loadCircleWithBorderImage(context, url, borderWidth, borderColor, imageView, placeHolderImageView);
    }

    public static void loadCircleWithBorderImage(Context context, String url, int borderWidth, @ColorInt int borderColor, ImageView imageView, @DrawableRes int placeHolder) {
        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .url(url)
                        .transformation(new CircleCrop())
                        .isCrossFade(false)
                        .errorPic(placeHolder)
                        .placeholder(placeHolder)
                        .imageView(imageView)
                        .build());
    }

    /**
     * 提供了一下如下变形类，支持叠加使用
     * BlurTransformation
     * GrayScaleTransformation
     * RoundedCornersTransformation
     * CircleCrop
     * CenterCrop
     */
    public static void loadImageWithTransformation(Context context, String url, ImageView imageView, BitmapTransformation... bitmapTransformations) {
        loadImageWithTransformation(context, url, imageView, R.color.transparent, bitmapTransformations);
    }

    public static void loadImageWithTransformation(Context context, String url, ImageView imageView, @DrawableRes int placeHolder, BitmapTransformation... bitmapTransformations) {
        loadImage(context,
                GlideConfigImpl
                        .builder()
                        .url(url)
                        .transformation(bitmapTransformations)
                        .isCrossFade(false)
                        .errorPic(placeHolder)
                        .placeholder(placeHolder)
                        .imageView(imageView)
                        .build());
    }


    /**
     * 加载本地图片
     *
     * @param context
     * @param drawableId
     * @param imageView
     */
    public static void loadImage(Context context, @RawRes @DrawableRes @Nullable Integer drawableId, ImageView imageView) {
        loadImage(context, GlideConfigImpl
                .builder()
                .drawableId(drawableId)
                .isCropCenter(true)
                .imageView(imageView)
                .build());
    }

    /**
     * 预加载
     *
     * @param context
     * @param url
     */
    public static void preloadImage(Context context, String url) {
        Glide.with(context).load(url).preload();
    }

    @SuppressLint("CheckResult")
    public static void loadImage(Context context, GlideConfigImpl config) {
        Preconditions.checkNotNull(context, "Context is required");
        Preconditions.checkNotNull(config, "ImageConfigImpl is required");

        Preconditions.checkNotNull(config.getImageView(), "ImageView is required");
        GlideRequests requests;
        requests = EasyGlideApp.with(context);
        GlideRequest<Drawable> glideRequest = null;
        if (config.getDrawableId() != 0) {
            glideRequest = requests.load(config.getDrawableId());
        } else {
            glideRequest = requests.load(config.getUrl());
        }


        //缓存策略
        switch (config.getCacheStrategy()) {
            case 1:
                glideRequest.diskCacheStrategy(DiskCacheStrategy.NONE);
                break;
            case 2:
                glideRequest.diskCacheStrategy(DiskCacheStrategy.RESOURCE);
                break;
            case 3:
                glideRequest.diskCacheStrategy(DiskCacheStrategy.DATA);
                break;
            case 4:
                glideRequest.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC);
                break;
            default:
                glideRequest.diskCacheStrategy(DiskCacheStrategy.ALL);
                break;
        }

//        if (config.isCrossFade()) {
//            DrawableCrossFadeFactory factory = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();
//            glideRequest.transition(withCrossFade(factory));
//        }
        glideRequest.dontAnimate();

        if (config.isImageRadius()) {
            glideRequest.transform(new RoundedCorners(config.getImageRadius()));
        }

        if (config.isBlurImage()) {
            glideRequest.transform(new BlurTransformation(config.getBlurValue()));
        }

        if (config.getPlaceHolderDrawable() != null) {
            glideRequest.placeholder(config.getPlaceHolderDrawable());
        }

        //设置请求 url 为空图片
        if (config.getFallback() != 0) {
            glideRequest.fallback(config.getFallback());
        }

        if (config.getResizeX() != 0 && config.getResizeY() != 0) {
            glideRequest.override(config.getResizeX(), config.getResizeY());
        }

        if (config.decodeFormate() != null) {
            glideRequest.format(config.decodeFormate());
        }

        if (config.getRequestListener() != null) {
            glideRequest.addListener(config.getRequestListener());
        }
        //设置占位符
        if (config.getPlaceholder() != 0) {
            glideRequest.placeholder(config.getPlaceholder());
        }
        //设置错误的图片
        if (config.getErrorPic() != 0) {
            glideRequest.error(config.getErrorPic());
        }
        //glide用它来改变图形的形状
        if (config.getTransformation() != null) {
            glideRequest.transform(config.getTransformation());
        }
        //使用第三方库来改变图形的形状
        if (config.getBaseRequestOptions() != null) {
            glideRequest.apply(config.getBaseRequestOptions());
        }
        if (config.isCropCenter()) {
            glideRequest.centerCrop();
        }
        if (config.isCropCircle()) {
            glideRequest.circleCrop();
        }
        if (config.isFitCenter()) {
            glideRequest.fitCenter();
        }
        if (config.getOnProgressListener() != null) {
            ProgressManager.addListener(config.getUrl(), config.getOnProgressListener());
        }

        glideRequest.dontAnimate().into(new GlideImageViewTarget(config.getImageView(), config.getUrl()));

    }


    /**
     * 取消图片加载
     */
    public static void clearImage(final Context context, ImageView imageView) {
        EasyGlideApp.get(context).getRequestManagerRetriever().get(context).clear(imageView);
    }

}
