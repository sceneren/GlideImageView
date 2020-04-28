package wiki.scene.glideimageview.sample.model;

import wiki.scene.glide.widget.ImageData;

import java.io.Serializable;
import java.util.List;

/**
 * @author by sunfusheng on 2017/6/27.
 */
public class ImageModel implements Serializable {
    public String desc;
    public List<ImageData> images;

    public ImageModel(String desc, List<ImageData> images) {
        this.desc = desc;
        this.images = images;
    }
}
