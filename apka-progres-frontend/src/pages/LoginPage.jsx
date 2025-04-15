import React, { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import "../styles/loginPage.css";
import LoginForm from "../components/LoginForm.jsx"; // Importuj komponent formularza logowania

const LoginPage = () => {
  const navigate = useNavigate();
  return (
    <div className="mainPage">
      <div className="LoginContainer">
        <div className="LoginPageNavBar">
          <h2>Login Page</h2>
        </div>
        <div className="loginFormContainer">
          <LoginForm></LoginForm>
        </div>
        <div className="Footer">
          <h2>Footer</h2>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
