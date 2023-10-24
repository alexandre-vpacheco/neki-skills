import './App.css';
import Login from './Pages/Login/Login';
import Home from './Pages/Home/Home';
import Cadastro from './Pages/Cadastro/Cadastro';
import NotFound from './Pages/NotFound/NotFound';
//import Rotas from './Routes/Routes';
import { BrowserRouter, Route, Routes } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        {/* ROTAS PÚBLICAS */}
        <Route path="/Login" element={<Login />} />
        <Route path="/Cadastro" element={<Cadastro />} />

        {/* ROTAS USUÁRIO */}
        <Route path="/" element={<Home />} />
        <Route path="/Home" element={<Home />} />

        {/* OUTRAS */}
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
