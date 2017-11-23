package com.example.guillermo.appturnos.turno.ui;

/**
 * Created by Guillermo on 05/10/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.guillermo.appturnos.R;
import com.example.guillermo.appturnos.reservarturno.ui.ReservaActivity;
import com.example.guillermo.appturnos.turnoslist.TurnosListPresenter;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ExpandableListAdapter extends BaseExpandableListAdapter {


    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
            ButterKnife.bind(this, convertView);
        }

        final TextView txtListChild = (TextView) convertView
                .findViewById(R.id.complejo);
        txtListChild.setText(childText);
        txtListChild.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Turno seleccionado", (String) getChild(groupPosition, childPosition) + getGroup(groupPosition));
                Intent i = new Intent(_context, ReservaActivity.class);
                i.putExtra(ReservaActivity.FECHA, "2017");
                i.putExtra(ReservaActivity.CANCHA, (String) getChild(groupPosition, childPosition));
                i.putExtra(ReservaActivity.HORA, (String) getGroup(groupPosition));
                _context.startActivity(i);


            }
        });
        return convertView;
    }


    public void add(HashMap<String, List<String>> listDataChild) {
        this._listDataChild = listDataChild;
        for (String key : listDataChild.keySet()) {
            this._listDataHeader.add(key);// agrego String a la cabecera
            Log.d("Expandable List ", String.valueOf(listDataChild.get(key)));

        }
        notifyDataSetChanged();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);

        }


        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.horaturno);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);


        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}