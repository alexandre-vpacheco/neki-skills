import { Routes, Route, BrowserRouter } from 'react-router-dom';
import { NotFound } from '../Pages/NotFound/NotFound';
import Home from '../Pages/Home/Home';
import Login from '../Pages/Login/Login';
import Cadastro from '../Pages/Cadastro/Cadastro';


function Rotas() {

    //const { userData } = useContext(AuthContext)

    return (
        <>
            <Routes>
                {/* ROTAS PUBLICAS */}
                <Route path="/Login" element={<Login />} />
                <Route path="/Cadastro" element={<Cadastro />} />

                {/* ROTAS USUÁRIO */}
                <Route path="/" element={<Home />} />
                <Route path="/Home" element={<Home />} />

                {/* OUTRAS */}
                <Route path="*" element={<NotFound />} />
            </Routes>
        </>
    )
}

export default Rotas