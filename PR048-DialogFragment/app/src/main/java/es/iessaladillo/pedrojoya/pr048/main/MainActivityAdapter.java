package es.iessaladillo.pedrojoya.pr048.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import es.iessaladillo.pedrojoya.pr048.R;
import es.iessaladillo.pedrojoya.pr048.data.model.Student;

class MainActivityAdapter extends ArrayAdapter<Student> {

    private final ArrayList<Student> students;
    private final LayoutInflater inflater;

    public MainActivityAdapter(Context contexto, ArrayList<Student> students) {
        super(contexto, R.layout.activity_main_item, students);
        this.students = students;
        inflater = LayoutInflater.from(contexto);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.activity_main_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        onBindViewHolder(holder, position);
        return convertView;
    }

    private void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.bind(students.get(position));
    }

    static class ViewHolder {

        private final ImageView imgAvatar;
        private final TextView lblName;
        private final TextView lblAddress;

        public ViewHolder(View itemView) {
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            lblName = itemView.findViewById(R.id.lblName);
            lblAddress = itemView.findViewById(R.id.lblAddress);
        }

        public void bind(Student student) {
            Picasso.with(imgAvatar.getContext())
                    .load(student.getPhotoUrl())
                    .placeholder(R.drawable.ic_person_black_24dp)
                    .error(R.drawable.ic_person_black_24dp)
                    .into(imgAvatar);
            lblName.setText(student.getName());
            lblAddress.setText(student.getAddress());
        }
    }

}