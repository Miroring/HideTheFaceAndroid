package cin.ufpe.br.Interfaces;

import org.opencv.core.Mat;

/**
 * Created by eduardo on 31/10/2016.
 */

public interface BlurImage {

    Mat DesfocarImagem(Mat mat);

    Mat Desfocar(Mat image);
}