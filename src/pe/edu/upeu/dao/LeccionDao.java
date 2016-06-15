package pe.edu.upeu.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import pe.edu.upeu.conn.DBConn;
import pe.edu.upeu.to.LeccionTo;

public class LeccionDao extends DBConn {
	SQLiteDatabase db;
	Cursor cur;
	String sql;
	public LeccionDao(Context contex) {
		super(contex);
		// TODO Auto-generated constructor stub
	}
	
	public  List<LeccionTo> listar(){
		ArrayList<LeccionTo> lista=new ArrayList<LeccionTo>();
		LeccionTo to;
		db=getReadableDatabase();
		sql="select * from leccion";
		cur=db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to=new LeccionTo();
			to.setId_leccion(cur.getInt(0));
			to.setNombre(cur.getString(1));		
			lista.add(to);			
		}
		return lista;
	}
	
	public List<LeccionTo> buscarLeccionPorId(int id){
		ArrayList<LeccionTo> lista=new ArrayList<LeccionTo>();
		LeccionTo to;
		db=getReadableDatabase();
		sql="select * from leccion where id_leccion="+id+" ";
		cur=db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to=new LeccionTo();
			to.setId_leccion(cur.getInt(0));
			to.setNombre(cur.getString(1));					
			lista.add(to);
		}		
		return lista;
	}	

}
