package pe.edu.upeu.main;

import java.util.Iterator;
import java.util.List;

import pe.edu.upeu.dao.CuestionarioDao;
import pe.edu.upeu.dao.LeccionDao;
import pe.edu.upeu.main.R;
import pe.edu.upeu.to.CuestionarioTo;
import pe.edu.upeu.to.DecisionTo;
import pe.edu.upeu.to.LeccionTo;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	TableLayout table;
	CuestionarioDao daox;
	LeccionDao dao;
	CuestionarioDao daoc;
	List<LeccionTo> leccionList;
	List<CuestionarioTo> cuestionarioList;
	List<DecisionTo> decisionList;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);			
		table=(TableLayout)findViewById(R.id.tablaLeccion);
		dao=new LeccionDao(this);
		daoc = new CuestionarioDao(this);
		table.removeAllViews();
		TableRow tData;
		TextView num, nombre, opciones;
		int i=0;
		ImageButton imgVer;	
		Button btnVer;
		LeccionTo to;
		
		List<LeccionTo> lista=dao.listar();
		Iterator<LeccionTo> iterator = lista.iterator();
		
		final Intent intent = new Intent(this, Cuestionario.class);
		
		OnClickListener opcVer = new OnClickListener(){
			@Override
			public void onClick(View v) {
//				daoc = new CuestionarioDao(v.getContext());
//				String parametro = v.getTag().toString();
//				Log.i("VERRR opcVer1 ------", parametro);//				
//				startActivity(new Intent(v.getContext(), Cuestionario.class));				
				intent.putExtra("parametro", v.getTag().toString());				
				v.getContext().startActivity(intent);
			}			
		};
		
		while(iterator.hasNext()){
			if(i==0){
				tData=new TableRow(this);
				
				num=new TextView(this);
				num.setText("");
				num.setWidth(10);	
				tData.addView(num);
				
				nombre=new TextView(this);
				nombre.setText("TÍTULO");
//				nombre.setTextSize(16);				
				nombre.setTextColor(Color.parseColor("#aaaaaa"));
				tData.addView(nombre);				
				
				opciones=new TextView(this);
				opciones.setText("OPCIÓN");
				nombre.setTextSize(16);
				opciones.setTextColor(Color.parseColor("#aaaaaa"));
				tData.addView(opciones);		
								
				table.addView(tData);
			}
			
			to=new LeccionTo();
			to=iterator.next();
			
			i++;
			
			tData=new TableRow(this);
			num=new TextView(this);
			num.setText(String.valueOf(i));
			tData.addView(num);
						
			nombre = new TextView(this);
			nombre.setText(to.getNombre());
//			nombre.setWidth(300);
			tData.addView(nombre);				
			
			imgVer=new ImageButton(this);
			imgVer.setImageResource(R.drawable.pluma);			
			imgVer.setTag(to.getId_leccion());
			imgVer.setMinimumHeight(20);
			imgVer.setMaxHeight(30);
			imgVer.setOnClickListener(opcVer);
			tData.addView(imgVer);	
			
			table.addView(tData);			
			Log.i("Dato Llega", to.getId_leccion()+" - "+to.getNombre());
		}
	}
	
	
//	public void selectLeccion(final LeccionTo to){
//		daox=new CuestionarioDao(this);
//		//poemaList=daox.listarAutorPoema(to.getIdautor());		
//		cuestionarioList=daox.listarCuestionarioPorLeccion(to.getId_leccion());
//		
//		int count = cuestionarioList.size();	
//		CuestionarioTo toc;
//		Log.i("DatoLlega", to.getNombre());
//		Log.i("DatoLlegaId", ""+to.getId_leccion());
//		Iterator<CuestionarioTo> iterator=cuestionarioList.iterator();
//		final String[] chapterNames = new String[cuestionarioList.size()];
//		final CuestionarioTo[] tox=new CuestionarioTo[cuestionarioList.size()];		
//		if (count == 0) {
//			//Log.i("VERRR", tox[0].getPoema());
//			//gotoAutorPoema(tox[0], 1);
//		}
//		else {			
//
//			int i=0;
//			while(iterator.hasNext()){			
//				toc=new CuestionarioTo();				
//				toc=(CuestionarioTo)iterator.next();			
//			chapterNames[i] = to.getNombre();
//			tox[i]=toc;
//			Log.i("VERRR", tox[0].getPregunta());
//			i++;
//			}
//			
//		    AlertDialog.Builder builder = new AlertDialog.Builder(this);
//		    builder.setTitle(to.getNombre());
//		    builder.setSingleChoiceItems(chapterNames, -1, new DialogInterface.OnClickListener() {
//
//			public void onClick(DialogInterface dialog, int which) {				
//				gotoCuestionario(tox[which], which+1);
//			    dialog.cancel();
//			}
//		    });
//		    
//		    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//			public void onClick(DialogInterface dialog, int whichButton) {
//			    // Canceled.
//			    dialog.cancel();
//			}
//		    });
//		    builder.show();
//			}
//		}
//	
//		public void gotoCuestionario(final CuestionarioTo to, final int valor){
//			Intent inte=new Intent(MainActivity.this, CuestionarioDao.class);
//			inte.putExtra("Id", to.getId_cuestionario());
//			inte.putExtra("Titulo", to.getPregunta());
//			startActivity(inte);
//		}

		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
