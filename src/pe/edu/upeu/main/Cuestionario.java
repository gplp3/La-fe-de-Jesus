package pe.edu.upeu.main;

import java.util.Iterator;
import java.util.List;

import pe.edu.upeu.dao.CuestionarioDao;
import pe.edu.upeu.dao.LeccionDao;
import pe.edu.upeu.main.R;
import pe.edu.upeu.to.CuestionarioTo;
import pe.edu.upeu.to.LeccionTo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Cuestionario extends ActionBarActivity{
	public View navigationPanel;	
	CuestionarioDao dao;
	LeccionDao daol;
	CuestionarioTo to;
	LeccionTo tol;
	
	TableLayout tlayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cuestionario);
		tlayout = (TableLayout) findViewById(R.id.tablaCuestionario);
		dao = new CuestionarioDao(this);
		daol = new LeccionDao(this);
		TableRow tData;
		TextView num, pregunta, verso, nombre;
		EditText respuesta;
		int i=0;
		//recibiendo parametro
		Bundle bunX=getIntent().getExtras();
		String idl = bunX.get("parametro").toString();
		Log.i("Llego el objeto", ""+idl);
//		idl.setText(bunX.getString("Vusuario"));
		
 
//		Obteniendo el cuestionario
//		int id = Integer.parseInt(idl);
//		Log.i("El id convertido es ", ""+id);
		
		List<CuestionarioTo> lista = dao.listarCuestionarioPorLeccion(Integer.parseInt(idl));
		Log.i("Paso por el metodo listar", "lista "+lista);
		Iterator<CuestionarioTo> iterator = lista.iterator();
		Log.i("Paso por el iterator", ""+iterator);
		while (iterator.hasNext()) {

			if(i==0){				
				to = new CuestionarioTo();
				to = iterator.next();
				
				List<LeccionTo> leccionTos = daol.buscarLeccionPorId(to.getId_leccion());
				Log.i("Listar leccion", "lista "+leccionTos);
				Iterator<LeccionTo> iter = leccionTos.iterator();	
				tol = new LeccionTo();
				tol = iter.next();
				
				tData=new TableRow(this);
				
				num=new TextView(this);
				num.setText("");
				num.setWidth(10);	
				tData.addView(num);
				
				nombre=new TextView(this);
				nombre.setText(tol.getNombre());
				nombre.setTextColor(Color.parseColor("#3300aa"));
				nombre.setTextSize(20);
				tData.addView(nombre);			
								
				tlayout.addView(tData);
				
			}
			
			to = new CuestionarioTo();
			to = iterator.next();
			i++;
			
			Log.i("var ", ""+to.getId_cuestionario()+" "+to.getPregunta());
			
			tData = new TableRow(this);
			
			num = new TextView(this);
			num.setText(String.valueOf(i));
			tData.addView(num);
			
			String vers = to.getVerso();	
						
			pregunta = new TextView(this);
			pregunta.setText(to.getPregunta()+" "+vers);//+" "+to.getVerso()
			pregunta.setWidth(370);			
			tData.addView(pregunta);
			
//			verso = new TextView(this);
//			verso.setText(to.getVerso());
//			verso.setTextColor(Color.parseColor("#0000ff"));
//			verso.setWidth(100);
//			tData.addView(verso);
			
			int btnSave=1;
			
			respuesta = new EditText(this);
			respuesta.setText(to.getRespuesta());
			respuesta.setId(btnSave);
			tData.addView(respuesta);
			
			tlayout.addView(tData);			
		}
		
	}

	
	public Cuestionario() {
		// TODO Auto-generated constructor stub
	}
}
