import './styles/App.css';
import { BrowserRouter as Router, Routes, Route, useNavigate } from "react-router-dom";
import LoginPage from './pages/LoginPage.jsx'; // Strona logowania
import HomePage from './pages/HomePage.jsx'; // Przykładowa strona główna
import RegisterPage from './pages/RegisterPage.jsx'; // Przykładowa strona główna

function App() {
  return (
    <Router> {/* Router owijający całą aplikację */}
      <div className='main'>
        <Routes>
          <Route path="/" element={<HomePage />} /> {/* Strona główna */}
          <Route path="/singin" element={<LoginPage />} /> {/* Strona logowania */}
          <Route path="/singup" element={<RegisterPage />} /> {/* Strona logowania */}
          
        </Routes>
      </div>
    </Router>
  );
}

export default App;
