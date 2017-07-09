package mahesh.webservice.com.webservicetestassignment.activity.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.VolleyError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import mahesh.webservice.com.webservicetestassignment.R;
import mahesh.webservice.com.webservicetestassignment.activity.adapter.CityRecyclerAdapter;
import mahesh.webservice.com.webservicetestassignment.activity.adapter.ItemClickListener;
import mahesh.webservice.com.webservicetestassignment.activity.network.ApiConfig;
import mahesh.webservice.com.webservicetestassignment.activity.network.ResponseListener;
import mahesh.webservice.com.webservicetestassignment.activity.network.RestProcessor;
import mahesh.webservice.com.webservicetestassignment.activity.network.model.CountryRestResponse;
import mahesh.webservice.com.webservicetestassignment.activity.utils.Utils;

public class SelectCityActivity extends AppCompatActivity implements ItemClickListener, View.OnClickListener {
    @InjectView(R.id.txtCancelActivity)
    TextView txtCancelActivity;
    TextView txtShowMapFromIP;
    private ProgressDialog progressDialog;
    private List<CountryRestResponse.Result> popularCityList = new ArrayList<CountryRestResponse.Result>();
    private EditText edtSearchText;
    private RecyclerView recyclerViewCity;
    private CityRecyclerAdapter adapter;

    //Mahesh Saini
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_select_city);
        ButterKnife.inject(this);
        controlRegistration();
    }

    private void controlRegistration() {
        edtSearchText = (EditText) findViewById(R.id.edtSearchText);
        txtShowMapFromIP = (TextView) findViewById(R.id.txtShowMapFromIP);
        recyclerViewCity = (RecyclerView) findViewById(R.id.recyclerViewCity);
        getCityName("");
        recyclerViewCity.setHasFixedSize(true);
        recyclerViewCity.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CityRecyclerAdapter(this, popularCityList);
        recyclerViewCity.setAdapter(adapter);
        adapter.setClickListener(this);
        txtShowMapFromIP.setOnClickListener(this);

        setupSearchView();
    }

    private void setupSearchView() {
        edtSearchText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() >= 3)
                    getCityName(s.toString());
                adapter.filter(s.toString());
            }
        });
    }

    public boolean onQueryTextChange(String newText) {
        getCityName(newText);
        adapter.filter(newText);
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private void getCityName(String cityKeyWord) {
        //progress bar dialog
        progressDialog = new ProgressDialog(this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.show();
//        final JSONObject getCityObject = new JSONObject();
//        try {
//            getCityObject.put("text=", cityKeyWord);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        RestProcessor.INSTANCE.doGet(new HashMap<String, String>(), ApiConfig.API_GET_STATE + cityKeyWord, new ResponseListener<CountryRestResponse>() {
            @Override
            public void onRestResponse(CountryRestResponse responseData) {
                progressDialog.dismiss();
                if (responseData != null) {
                    CountryRestResponse.RestResponse cityResult = responseData.getRestResponse();
                    if (cityResult != null) {
                        if (cityResult.getMessages() != null) {
                            popularCityList = cityResult.getResult();
                            adapter.addData(popularCityList);
                            adapter.notifyDataSetChanged();
                            //  Utils.makeAlert(SelectCityActivity.this, cityResult.getMessage());
                        }
                    } else {

                    }
                } else {

                }
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Utils.makeAlert(SelectCityActivity.this, "Error");
            }
        }, CountryRestResponse.class);

    }

    //Recycler view click
    @Override
    public void onClick(View view, int position) {
        CountryRestResponse.Result cityResult = popularCityList.get(position);
        //Utils.alert(SelectCityActivity.this, cityResult.getCity() + " , " + cityResult.getCityId());
        Intent i_location = new Intent();
        setResult(RESULT_OK, i_location);
//        SharedPreferencesUtil.savePreferences(SelectCityActivity.this, IConstants.CITY_NAME, cityResult.getCity() + "" == null ? "" : cityResult.getCity() + "");
//        SharedPreferencesUtil.savePreferences(SelectCityActivity.this, IConstants.CITY_ID, cityResult.getCityId() + "" == null ? "" : cityResult.getCityId() + "");
//        finish();

    }

    //button or textview click
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txtShowMapFromIP:
                Intent i = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(i);
                break;
        }
    }
}
