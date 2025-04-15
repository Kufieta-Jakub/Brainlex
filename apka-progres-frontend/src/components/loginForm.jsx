import React, {useState} from "react";
import "../styles/LoginContainer.css";
import { Navigate, useNavigate } from "react-router-dom";

const LoginForm = () => {
    const navigate = useNavigate();
    return (
        <div className="LoginForm">
            <h2>Sing in</h2>
            <a>E-mail</a>
            <input type="text" placeholder="Username" className="login-input" />
            <a>Password</a>
            <input type="password" placeholder="Password" className="login-input" />
            <button className="login-button"
                onClick={() => {
                    console.log("Login button clicked");
                    navigate("/singup");
                }}
            >Sing up</button>
            <button onClick={()=>{navigate("/");}}>Home page</button>
            
        </div>
    );

};

export default LoginForm;