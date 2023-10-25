import React, { useState } from "react";
import './Login.css'
import { useNavigate } from "react-router-dom";
import axios from 'axios';

const Login = () => {

    const navigate = useNavigate();

    const [username, setUsername] = useState('');

    const [senha, setSenha] = useState('');

    const data = {
        username: username,
        senha: senha,
    };

    const [isLoading, setIsLoading] = useState(false);

    const [hidePass, setHidePass] = useState(false);

    const handleLogin = async () => {

        if (username == "" || senha == "") {
            alert('Todos os campos devem estar preenchidos!');
            return;

            } else {

                if(username=="alex" && senha =="123")
                        navigate(`/Home`);                                
            }
        }

        const handleCadastro = () => {
            navigate(`/Cadastro`);
        }

        return (

            <>
                <div style={{ display: isLoading ? "flex" : "none" }} className="modal">
                    <div className="modal-content">
                        <div className="loader"></div>
                        <div className="modal-text">Carregando...</div>
                    </div>
                </div>
                <div className="r-container">
                    <span className="title">Sistema Skill</span>
                    <form >

                        <input
                            type="text"
                            placeholder="Usuário"
                            id="username"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />

                        <input type={hidePass ? "text" : "password"}
                            placeholder="Senha"
                            id="senha"
                            value={senha}
                            onChange={(e) => setSenha(e.target.value)}
                        />

                        <button className="button1" onClick={handleLogin}>Entrar</button>
                    </form>
                    <button className="button2" onClick={handleCadastro}><p >Ainda não possui conta? Cadastre-se.</p></button>
                </div>
            </>
        )
    }

    export default Login