package com.android.SilentChat;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SilentChat extends Activity {
	private static final int REQUEST_ENABLE_BT = 0;
	/** Called when the activity is first created. */
	// Local Bluetooth adapter
	private BluetoothAdapter mBluetoothAdapter = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// Get local Bluetooth adapter
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		// If the adapter is null, then Bluetooth is not supported
		if (mBluetoothAdapter == null) {
			Toast.makeText(this, "Bluetooth is not available",
					Toast.LENGTH_LONG).show();
			//finish();
			return;
		}
		// If BT is not on, request that it be enabled.
        // setupChat() will then be called during onActivityResult
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BT);
            Toast.makeText(this, "Bluetooth is not Enable",
					Toast.LENGTH_LONG).show();
        // Otherwise, setup the chat session
        } else {
        	Toast.makeText(this, "Bluetooth is Enable",
					Toast.LENGTH_LONG).show();
        }
	}
}