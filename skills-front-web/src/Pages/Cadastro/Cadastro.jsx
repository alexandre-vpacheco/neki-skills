import React from "react";
import './Cadastro.css'
import { useNavigate } from "react-router-dom";

const Cadastro = () => {

    const navigate = useNavigate();

    const handleSalvar = () => {
        navigate(`/Login`);
    }

    const handleLogin = () => {
        navigate(`/Login`);
    }

    return (
        <div className="r-container">
            <span className="title">Sistema Skill: Cadastro</span>
            <form >
                <input type="text" placeholder="Usuário" />
                <input type="senha" placeholder="Senha" />
                <input type="senha" placeholder="Confirmar senha" />
                <button className="button1" onClick={handleSalvar}>Salvar</button>
            </form>
            <button className="button2" onClick={handleLogin}><p >Já possui conta? Login.</p></button>
        </div>

    )
}

export default Cadastro