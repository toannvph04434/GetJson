package tintuc.diepnvph04430.diep.tintuc;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class TongHop extends Fragment {
    View tonghop;
    final String API = "http://webtintuccc.esy.es/";
    ListView listView;

    ArrayList<tintuc> arrTT;

    public TongHop() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        tonghop = inflater.inflate(R.layout.activity_one_fragment, container, false);
        listView = (ListView) tonghop.findViewById(R.id.listView);
        arrTT = new ArrayList<tintuc>();

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new doGetTT().execute(API);
            }
        });


        return tonghop;

    }


    class doGetTT extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {

            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONArray jsonArray = new JSONArray(s);
                Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject objecttt = jsonArray.getJSONObject(i);
                    arrTT.add(new tintuc(
                            objecttt.getInt("id"),
                            objecttt.getString("loaitin"),
                            objecttt.getString("tieude"),
                            objecttt.getString("anh"),
                            objecttt.getString("noidung"),
                            objecttt.getString("ngay"),
                            objecttt.getString("gio")

                    ));
                }
                Custom_tonghop listAdapter = new Custom_tonghop(getActivity(), R.layout.custom_dong, arrTT);
                listView.setAdapter(listAdapter);
                Toast.makeText(getActivity(), "" + arrTT.size(), Toast.LENGTH_LONG).show();
//                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        //Toast.makeText(getApplicationContext(),""+arrTT.get(position).getIdtt(),Toast.LENGTH_LONG).show();
//                        Intent intent = new Intent(TongHop.this, ChiTiet.class);
//                        intent.putExtra("name", String.valueOf(arrTT.get(position).getIdtt()));
//                        startActivity(intent);
//                    }
//                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static String docNoiDung_Tu_URL(String theUrl) {
        StringBuilder content = new StringBuilder();

        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}
