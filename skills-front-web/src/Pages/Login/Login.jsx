import React from "react";
import './Login.css'
import { useNavigate } from "react-router-dom";

const Login = () => {

    const navigate = useNavigate();

    const handleLogin = () => {
        navigate(`/Home`);
    }

    const handleCadastro = () => {
        navigate(`/Cadastro`);
    }

    return (
        <div className="r-container">
            <span className="title">Sistema Skill</span>
            <form >
                <input type="text" placeholder="Usuário" />
                <input type="senha" placeholder="Senha" />
                <button className="button1" onClick={handleLogin}>Entrar</button>
            </form>
            <button className="button2" onClick={handleCadastro}><p >Ainda não possui conta? Cadastre-se.</p></button>
        </div>
    )
}

export default Login