import React, { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";


const RegisterPage = () => {
  const navigate = useNavigate();
  return (
    <div className="mainPage">
        <div className="LoginContainer">
            <div className="LoginPageNavBar">
            <h2>Register Page</h2>
            </div>
            <div className="loginFormContainer">
            <h2>Sing up</h2>
            <a>E-mail</a>
            <input type="text" placeholder="Username" className="login-input" />
            <a>Password</a>
            <input type="password" placeholder="Password" className="login-input" />
            <button className="login-button"
                onClick={() => {
                navigate("/singin"); // Przekierowanie na stronę główną po kliknięciu
                }}
            >Sing in</button>
            <button onClick={()=>{navigate("/");}}>Home page</button>
            </div>
        </div>
    </div>
  );
};

export default RegisterPage;
