package pe.edu.upeu.dao;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.conn.DBConn;
import pe.edu.upeu.to.DecisionTo;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DecisionDao extends DBConn {
	SQLiteDatabase db;
	Cursor cur;
	String sql;
	public DecisionDao(Context contex) {
		super(contex);
	}
	
	public List<DecisionTo> listar() {
		ArrayList<DecisionTo> lista = new ArrayList<DecisionTo>();
		DecisionTo to;
		db = getReadableDatabase();
		sql = "select * from decision";
		cur = db.rawQuery(sql, null);
		while(cur.moveToNext()){
			to = new DecisionTo();
			to.setId_decision(cur.getInt(0));
			to.setNombre(cur.getString(1));
			to.setVerso(cur.getString(2));
			to.setId_leccion(cur.getInt(3));
			to.setEstado(cur.getInt(4));
			lista.add(to);
		}
		return lista;
	}
}
