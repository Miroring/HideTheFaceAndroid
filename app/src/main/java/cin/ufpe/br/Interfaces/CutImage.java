package cin.ufpe.br.Interfaces;

import android.graphics.Bitmap;

import java.util.List;

import cin.ufpe.br.model.PropriedadesFace;

/**
 * Created by eduardo on 31/10/2016.
 */

public interface CutImage {
    List<PropriedadesFace> CortarImagem(List<PropriedadesFace> dados, byte[] imagem);
    List<PropriedadesFace> CortarImagem(List<PropriedadesFace> dados, Bitmap imagem);
}
