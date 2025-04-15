import React from "react";
import { Navigate, useNavigate } from "react-router-dom";

const HomePage = () => {
  const navigate = useNavigate();
  return (
    <div className="homePage">
      <h1>Welcome to the Home Page</h1>
      <button onClick={()=>{navigate("/singin");}}>Sing in page</button>
      <button onClick={()=>{navigate("/singup");}}>Sing up page</button>
      
    </div>
  );
};

export default HomePage;
