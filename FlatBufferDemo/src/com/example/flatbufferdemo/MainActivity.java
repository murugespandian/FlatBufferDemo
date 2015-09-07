package com.example.flatbufferdemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.flatbuffers.FlatBufferBuilder;

public class MainActivity extends ActionBarActivity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void parseData(View view)
	{
		new TestTask(this).execute();
	}

	class TestTask extends AsyncTask<Void, Void, NotebookList>
	{

		WeakReference<Activity> reference=null;

		public TestTask(Activity activity) 
		{
			reference=new WeakReference<Activity>(activity);
		}

		@Override
		protected NotebookList doInBackground(Void... params) 
		{

			FlatBufferBuilder builder=new  FlatBufferBuilder();

			int message=builder.createString("Fetched Successfully");
			int status=builder.createString("Fetched Successfully");


			int name=builder.createString("MYName");
			int notebookId=builder.createString("Great Name");
			int description=builder.createString("Great Description");
			int location=builder.createString("Chennai,India");
			int coverImageId=builder.createString("Iam CoverImage Id");

			int viewType=builder.createString("Grid");
			int sortType=builder.createString("LastAccessed");
			int sortOrder=builder.createString("Asc");

			int notebook=Notebook.createNotebook(builder, name, notebookId, false, description, location,2323, 3232, coverImageId, 3332323, 32, 343434);

			int[] notebooks={notebook};
			int vec=NotebookList.createNotebooksVector(builder,notebooks);

			int pageContext=PageContext.createPageContext(builder,viewType,sortType,sortOrder,100);

			int end=NotebookList.createNotebookList(builder, 200, status, message, vec, pageContext);

			/*
			 * For Manual Construction.
			 * For Struct Schema,create it inside the Start and End of the Table Schema.
			 * 
					    NotebookList.startNotebookList(builder);
						NotebookList.addCode(builder,200);
						NotebookList.addMessage(builder,message);
						NotebookList.addStatus(builder,status);
						NotebookList.addNotebooks(builder, vec);
						NotebookList.addPageContext(builder, pageContext);
						int end=NotebookList.endNotebookList(builder);
			 */

			NotebookList.finishNotebookListBuffer(builder,end);

			ByteBuffer byteBuffer=ByteBuffer.wrap(builder.sizedByteArray());

			return NotebookList.getRootAsNotebookList(byteBuffer);

		}

		@Override
		protected void onPostExecute(NotebookList result) 
		{
			Toast.makeText(reference.get(),result==null?"So sad,I am null":"Oh,yeah Iam success:"+result.message(),Toast.LENGTH_SHORT).show();;
		}

	}


	public NotebookList httpService()
	{
		FlatBufferBuilder builder=new  FlatBufferBuilder();

		InputStream inputStream=null;
		ByteArrayOutputStream outputStream=null;
		try
		{
			URL url = new URL("URL");
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();

			if(connection.getResponseCode()!=200)
			{
				return null;	
			
			}
			inputStream=connection.getInputStream();
			outputStream=new ByteArrayOutputStream();

			byte[] buffer=new byte[1024*8];

			int length=0;
			while ((length=inputStream.read(buffer))!=-1)
			{
				outputStream.write(buffer,0,length);
			}	


			ByteBuffer byteBuffer=ByteBuffer.wrap(builder.sizedByteArray());

			return NotebookList.getRootAsNotebookList(byteBuffer);

		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(inputStream!=null)
			{
				try
				{
					inputStream.close();
				}
				catch(Exception exception)
				{
					Log.e("FlatBuffer.Exception","Exception while closing the stream :",exception );
				}
			}
			if(outputStream!=null)
			{
				try
				{
					outputStream.close();
				}
				catch(Exception exception)
				{
					Log.e("FlatBuffer.Exception","Exception while closing the stream :",exception );
				}
			}

		}

		return null;
	}

}
