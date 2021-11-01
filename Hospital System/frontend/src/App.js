import logo from './logo.svg';
import './App.css';
import 'font-awesome/css/font-awesome.min.css';

function App() {
    return (
        <div>
            <h1>Welcome to RealFakeHospital!
            </h1>
            <div id="login_screen">
                <div className="left">

                </div>
                <div className="login">


                        <div className="body-form">

                            <form>
                                <div className="input_username">
                                    <label><i class="fa fa-user"></i></label>

                                    <input type="text" placeholder="Username"/>
                                </div>

                                <div className="input_password">
                                    <label><i class="fa fa-lock"></i></label>

                                    <input type="text" className="form-control" placeholder="Password"/>
                                </div>
                                <button type="button" className="btn btn-secondary btn-block">LOGIN</button>
                            </form>
                        </div>

                </div>


            </div>
        </div>

    );
}

export default App;
