package pe.edu.upeu.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pe.edu.upeu.conn.DBConn;
import pe.edu.upeu.to.PersonaTo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonaDao extends DBConn{

	SQLiteDatabase db;
	Cursor cur;
	String sql;
	public PersonaDao(Context contex) {
		super(contex);
		// TODO Auto-generated constructor stub
	}

	public  List<PersonaTo> listarPersonas(){
		ArrayList<PersonaTo> lista=new ArrayList<PersonaTo>();
		PersonaTo to;
		db=getReadableDatabase();
		sql="select * from persona ";
		cur=db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to=new PersonaTo();
			to.setId_persona(cur.getInt(0));
			to.setNombre(cur.getString(1));
			to.setUsuario(cur.getString(3));		
			lista.add(to);			
		}
		return lista;
	}
	
}
