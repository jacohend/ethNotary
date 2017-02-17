package ethnotary.jacohend.com.ethnotary;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import de.petendi.ethereum.android.EthereumAndroid;
import de.petendi.ethereum.android.EthereumAndroidFactory;
import de.petendi.ethereum.android.EthereumNotInstalledException;

public class EthNotary extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private final static String CONTRACT_BYTECODE = "6060604052341561000c57fe5b5b60006001819055505b5b610af5806100266000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806356ca623e14610051578063693ec85e1461010e578063f034d6b1146102f8575bfe5b341561005957fe5b610085600480803573ffffffffffffffffffffffffffffffffffffffff169060200190919050506103d8565b60405180806020018281038252838181518152602001915080519060200190808383600083146100d4575b8051825260208311156100d4576020820191506020810190506020830392506100b0565b505050905090810190601f1680156101005780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561011657fe5b610166600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506104bf565b6040518080602001806020018060200187815260200186815260200185815260200184810384528a8181518152602001915080519060200190808383600083146101cf575b8051825260208311156101cf576020820191506020810190506020830392506101ab565b505050905090810190601f1680156101fb5780820380516001836020036101000a031916815260200191505b50848103835289818151815260200191508051906020019080838360008314610243575b8051825260208311156102435760208201915060208101905060208303925061021f565b505050905090810190601f16801561026f5780820380516001836020036101000a031916815260200191505b508481038252888181518152602001915080519060200190808383600083146102b7575b8051825260208311156102b757602082019150602081019050602083039250610293565b505050905090810190601f1680156102e35780820380516001836020036101000a031916815260200191505b50995050505050505050505060405180910390f35b341561030057fe5b6103d6600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506108dd565b005b6103e06109fc565b6103e8610a10565b600060146040518059106103f95750595b908082528060200260200182016040525b509150600090505b60148110156104b4578060130360080260020a8473ffffffffffffffffffffffffffffffffffffffff1681151561044557fe5b047f010000000000000000000000000000000000000000000000000000000000000002828281518110151561047657fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b8080600101915050610412565b8192505b5050919050565b6104c76109fc565b6104cf6109fc565b6104d76109fc565b6000600060006000876040518082805190602001908083835b6020831061051357805182526020820191506020810190506020830392506104f0565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206000018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105dd5780601f106105b2576101008083540402835291602001916105dd565b820191906000526020600020905b8154815290600101906020018083116105c057829003601f168201915b505050505095506000876040518082805190602001908083835b6020831061061a57805182526020820191506020810190506020830392506105f7565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156106e45780601f106106b9576101008083540402835291602001916106e4565b820191906000526020600020905b8154815290600101906020018083116106c757829003601f168201915b505050505094506000876040518082805190602001908083835b6020831061072157805182526020820191506020810190506020830392506106fe565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156107eb5780601f106107c0576101008083540402835291602001916107eb565b820191906000526020600020905b8154815290600101906020018083116107ce57829003601f168201915b505050505093506000876040518082805190602001908083835b602083106108285780518252602082019150602081019050602083039250610805565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206003015492506000876040518082805190602001908083835b602083106108975780518252602082019150602081019050602083039250610874565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206004015491504390505b91939550919395565b60a0604051908101604052808381526020016108f8336103d8565b8152602001828152602001428152602001438152506000846040518082805190602001908083835b602083106109435780518252602082019150602081019050602083039250610920565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206000820151816000019080519060200190610992929190610a24565b5060208201518160010190805190602001906109af929190610a24565b5060408201518160020190805190602001906109cc929190610a24565b5060608201518160030155608082015181600401559050506001600081548092919060010191905055505b505050565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610a6557805160ff1916838001178555610a93565b82800160010185558215610a93579182015b82811115610a92578251825591602001919060010190610a77565b5b509050610aa09190610aa4565b5090565b610ac691905b80821115610ac2576000816000905550600101610aaa565b5090565b905600a165627a7a723058204e772ad8c666139dc95e45b8da1b22033160eb1acd99222202d458aa1f9f9eb20029";
    private final static String CONTRACT_ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"x\",\"type\":\"address\"}],\"name\":\"toString\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"title\",\"type\":\"string\"}],\"name\":\"get\",\"outputs\":[{\"name\":\"creator\",\"type\":\"string\"},{\"name\":\"sender\",\"type\":\"string\"},{\"name\":\"message\",\"type\":\"string\"},{\"name\":\"time\",\"type\":\"uint256\"},{\"name\":\"createdno\",\"type\":\"uint256\"},{\"name\":\"nowno\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"title\",\"type\":\"string\"},{\"name\":\"cr\",\"type\":\"string\"},{\"name\":\"mesg\",\"type\":\"string\"}],\"name\":\"add\",\"outputs\":[],\"payable\":false,\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"type\":\"constructor\"}]";
    private final static String CONTRACT_ADDRESS = "";
    private EthereumAndroid ethereumAndroid;

    EditText title;
    EditText document;
    EditText creator;
    EditText titleToRetrieve;
    Button add;
    Button retrieve;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eth_notary);
        title = (EditText)findViewById(R.id.editText);
        document = (EditText) findViewById(R.id.editText4);
        creator = (EditText) findViewById(R.id.editText2);
        titleToRetrieve = (EditText) findViewById(R.id.editText6);
        results = (TextView) findViewById(R.id.textView5);
        add = (Button) findViewById(R.id.button);
        retrieve = (Button) findViewById(R.id.button3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                writeDocument(title.getText().toString(), creator.getText().toString(), document.getText().toString());
            }
        });
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                readDocument(titleToRetrieve.getText().toString());
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initialize();
    }

    private void initialize() {
        EthereumAndroidFactory ethereumAndroidFactory = new EthereumAndroidFactory(this);
        try {
            ethereumAndroid = ethereumAndroidFactory.create();
        } catch (EthereumNotInstalledException e) {
            Toast.makeText(this, "ethereum not installed", Toast.LENGTH_LONG).show();
        }
    }

    private void readDocument(String title) {;
        final Contract documents = ethereumAndroid.contracts().bind(CONTRACT_ADDRESS, CONTRACT_ABI, Contract.class);
        final String t = title;
        Runnable readTask = new Runnable() {
            @Override
            public void run() {
                final String value;
                final long timestamp;
                try {
                    value = documents.getDoc(t);
                    timestamp = documents.getTimestamp(t);
                } catch (Exception e) {
                    return;
                }
                Runnable showResult = new Runnable() {
                    @Override
                    public void run() {
                        String res = String.format("@%s\n%s", timestamp, value);
                        results.setText(res);
                    }
                };
                EthNotary.this.runOnUiThread(showResult);
            }
        };
        new Thread(readTask, "read contract data thread").start();
    }

    private void writeDocument(final String title, final String creator, final String document) {
            final Contract documents = ethereumAndroid.contracts().bind(CONTRACT_ADDRESS, CONTRACT_ABI, Contract.class);
            Runnable writeTask = new Runnable() {
                @Override
                public void run() {
                    try {
                        documents.add(title, creator, document);
                    } catch (Exception e) {
                        return;
                    }
                    Runnable transactionTask = new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(EthNotary.this, "Upload complete.", Toast.LENGTH_LONG).show();
                        }
                    };
                    EthNotary.this.runOnUiThread(transactionTask);
                }
            };
            new Thread(writeTask, "write contract data thread").start();
        }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_eth_notary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
