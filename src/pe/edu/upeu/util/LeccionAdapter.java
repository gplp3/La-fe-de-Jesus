package pe.edu.upeu.util;

import java.util.List;

import pe.edu.upeu.main.R;
import pe.edu.upeu.main.MainActivity;
import pe.edu.upeu.to.LeccionTo;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LeccionAdapter extends ArrayAdapter<LeccionTo> {
	private static LayoutInflater inflater = null;
	private MainActivity context;
	public LeccionAdapter(MainActivity context, List<LeccionTo> objects) {
		super(context, R.layout.activity_main, objects );		
		this.context = context;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
    public static class ViewHolder{
        public TextView tituloNombre;
        public ImageView selectButton;
    }
    
    public View getView(final int position, View convertView, ViewGroup parent) {
    	View row = convertView;
        ViewHolder holder;
        
        if (row == null) {
    	    row = inflater.inflate(R.layout.activity_main,null);
                holder = new ViewHolder();
//                holder.tituloNombre = (TextView)row.findViewById(R.id.leccion_nombre);
//                holder.selectButton = (ImageView)row.findViewById(R.id.leccion_selection);
                row.setTag(holder);
    	}  else
            	holder = (ViewHolder)row.getTag();
	
        final LeccionTo to = (LeccionTo)super.getItem(position);
	
        holder.tituloNombre.setText(to.getNombre());
	
//        holder.selectButton.setOnClickListener(new View.OnClickListener() {
//	    
//	    public void onClick(View v) {
//	    	context.selectLeccion(to);
//	    }
//        });
    	
    	return row;
	}
}
