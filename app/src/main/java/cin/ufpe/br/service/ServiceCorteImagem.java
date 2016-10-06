package cin.ufpe.br.service;

import android.graphics.Bitmap;

import java.util.List;

import cin.ufpe.br.model.PropriedadesFace;

public class ServiceCorteImagem {

	public List<PropriedadesFace> CortarImagem(List<PropriedadesFace> dados, Bitmap imagem){
		
		for(PropriedadesFace dado : dados){
			dado.setImageCortada(Bitmap.createBitmap(imagem, dado.getX(), dado.getY(), dado.getWidth(), dado.getHeight()));
		}
		
		return dados;
	}
}