import './App.css';
import Login from './Pages/Login/Login';
import Home from './Pages/Home/Home';
import Cadastro from './Pages/Cadastro/Cadastro';
import NotFound from './Pages/NotFound/NotFound';
//import Rotas from './Routes/Routes';
import React from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';

function App() {

  return (
    <Router>
      <Routes>
        <Route path="/Login" element={<Login />} />
        <Route path="/Cadastro" element={<Cadastro />} />
        <Route path="/Home" element={<Home />} />
        <Route path="/" element={<Navigate to="Login" />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
  )
}

export default App
