package com.acelrtech.app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
 
public class ChartActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart);
        WebView webview = (WebView) findViewById(R.id.webView1);
        String content = "<html>"
                + "  <head>"
                + "    <script type=\"text/javascript\" src=\"jsapi.js\"></script>"
                + "    <script type=\"text/javascript\" src=\"jquery-2.0.3.min.js\"></script>"
                + "    <script type=\"text/javascript\">"  
                + "var SERVER = \"http://cloud.acelrtech.com:7777\";"
                + "      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
                + "      google.setOnLoadCallback(drawChart);"
                + "      function drawChart() {"
                + "        var data = google.visualization.arrayToDataTable(["
                + "          ['Year', 'Total Revenue', 'Total Cost'],"
                + "          ['2005',  1853413.72,      2068090.30],"
                + "          ['2006',  2172165.10,	2375283.67],"
                + "          ['2007',  2361936.63,	2560021.00],"
                + "          ['2008',  2520095.67,	2840954.43]"
                + "        ]);"
                + "        var options = {"
                + "          title: 'Transport Performance',"
                + "			 vAxis: {title: 'Amount (in Rupees)', titleTextStyle: {color: 'red'}},"
                + "          hAxis: {title: 'Year', titleTextStyle: {color: 'Green'}}"
                + "        };"
                + "        var chart = new google.visualization.BarChart(document.getElementById('chart_div'));"
                + "        chart.draw(data, options);"
                + "      }"
                + "      "
                + "function getAllSRTU() {"
                + " $(\"#srtu\").html(\"<option value=\'Test\'></option>\")"
                + "}"
                //+ "$(document).ready(function() {"
                + "getAllSRTU();"
                //+ "})"
                + "    </script>"
                + "  </head>"
                + "  <body>"
                + "View data by SRTU - <select id=\"srtu\" name=\"srtu\" onchange=\"alart(\'hi\');\"></select>"
                + "    <div id=\"chart_div\" style=\"width: 900px; height: 500px;\"></div>"
                //+ "       <img style=\"padding: 0; margin: 0 0 0 5px; display: block;\" src=\"acelr.png\"/>"
                + "  </body>" + "</html>";
 
        WebSettings webSettings = webview.getSettings();
        webview.setWebViewClient(new WebViewClient());
        webview.setWebChromeClient(new WebChromeClient() {
            public boolean onConsoleMessage(ConsoleMessage cm) {
                  Log.d("MyApplication", cm.message() + " -- From line "
                                       + cm.lineNumber() + " of "
                                       + cm.sourceId() );
                  return true;
                }
              });
        webSettings.setJavaScriptEnabled(true);
        //Needed for Cross domain origin access
        webSettings.setAllowFileAccessFromFileURLs(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webview.requestFocusFromTouch();
        //webview.loadDataWithBaseURL( "file:///android_asset/", content, "text/html", "utf-8", null );
        webview.loadUrl("file:///android_asset/ChartCode.html");
        //webview.loadUrl("javascript:getAllSRTU()");
    }
 
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        switch (item.getItemId()) {
        case R.id.action_to_image:
            Intent intent = new Intent(ChartActivity.this, GoogleImageGraphActivity.class);
            startActivity(intent);
            return true;
 
        default:
            return super.onOptionsItemSelected(item);
        }
    }*/
}
