package com.example.pienyritysappi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JobInfo extends AppCompatActivity {

    private TextView mTextViewResult;
    private TextView mTextViewDescription;
    private TextView mTextViewPricing;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info);
        mTextViewResult = findViewById(R.id.header);
        mTextViewDescription = findViewById(R.id.jobInfoTextView);
        mTextViewPricing = findViewById(R.id.pricingTextView);
        mQueue = Volley.newRequestQueue(this);
        jsonParse();

    }

    private void jsonParse(){
        String url = "http://mobiilisovellus.therozor.com:5000/services?user_id=5031bd69-c634-43dd-9000-c8fe0b984e85";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            JSONObject job = jsonArray.getJSONObject(0);   //tähän indeksi, monennenko työn haluaa (0=eka 1=toka jne. tullaan vaihtamaan id:llä haettavaksi)
                            String jobName = job.getString("service_title");
                            Double jobPrice = job.getDouble("service_price");
                            String jobPriceType = job.getString("service_type_string");
                            String jobDescription = job.getString("service_description");
                            String jobAvailability = job.getString("service_availability");
                            mTextViewResult.setText(jobName);
                            mTextViewDescription.setText(jobDescription + "\n\nSaatavuus:\n" + jobAvailability);
                            mTextViewPricing.setText(jobPriceType + "\n" + jobPrice.toString() + " €");



                        } catch (JSONException e) {
                            System.out.println("\nnyt ollaan onResponsen catchissä: JSONExceptionissa siis\n");
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("onErrorResponsessa ollaan.");
                error.printStackTrace();
            }
        });
        mQueue.add(request);
    }

    public void homeButtonClicked(View view)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void profileButtonClicked(View view)
    {
        Intent intent = new Intent(getApplicationContext(),CustomerProfile.class);
        startActivity(intent);
    }

    public void purchaseJobButtonClicked(View view)
    {
        Intent intent = new Intent(getApplicationContext(),ReservationActivity.class);
        startActivity(intent);
    }

    public void chatButtonClicked(View view)
    {

    }


}