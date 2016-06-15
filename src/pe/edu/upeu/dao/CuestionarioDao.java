package pe.edu.upeu.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import pe.edu.upeu.conn.DBConn;
import pe.edu.upeu.to.CuestionarioTo;

public class CuestionarioDao extends DBConn{
	SQLiteDatabase db;
	Cursor cur;
	String sql;
	public CuestionarioDao(Context contex) {
		super(contex);	
	}

	public  List<CuestionarioTo> listar(){
		ArrayList<CuestionarioTo> lista=new ArrayList<CuestionarioTo>();
		CuestionarioTo to;
		db=getReadableDatabase();
		sql="select * from cuestionario";
		cur=db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to=new CuestionarioTo();
			to.setId_cuestionario(cur.getInt(0));
			to.setPregunta(cur.getString(1));
			to.setVerso(cur.getString(2));
			to.setId_leccion(cur.getInt(3));		
			lista.add(to);			
		}
		return lista;
	}
	
	public List<CuestionarioTo> listarCuestionarioPorLeccion(int id){
		ArrayList<CuestionarioTo> lista=new ArrayList<CuestionarioTo>();
		CuestionarioTo to;
		db=getReadableDatabase();
		sql="select * from cuestionario where id_leccion="+id+" ";
		cur=db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to=new CuestionarioTo();
			to.setId_cuestionario(cur.getInt(0));
			to.setPregunta(cur.getString(1));
			to.setVerso(cur.getString(2));
			to.setRespuesta(cur.getString(3));
			to.setId_leccion(cur.getInt(4));		
			lista.add(to);
		}		
		return lista;
	}	
}
