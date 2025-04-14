import React, { useState } from "react";
import { Navigate, useNavigate } from "react-router-dom";
import "../styles/loginPage.css";

const LoginPage = () => {
  const navigate = useNavigate();
  return (
    <div className="mainPage">
      <div className="LoginContainer"></div>
      <h2>Login Page</h2>
    </div>
  );
};

export default LoginPage;
