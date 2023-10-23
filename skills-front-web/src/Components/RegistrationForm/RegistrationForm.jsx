import React, { useState } from 'react';
import './RegistrationForm.css'
import axios from 'axios';
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

function RegistrationForm() {

    const initialFormData = {
        username: '',
        senha: '',
        senhaConfirmacao: '',
      };

    const [formData, setFormData] = useState(initialFormData);

    const [username, setUsername] = useState("");

    const navigate = useNavigate();

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const [isLoading, setIsLoading] = useState(false);

    const handleLogin = () => {
        navigate(`/Login`);
    }

    const handleSubmit = (e) => {
        e.preventDefault();

        if (formData.senha !== formData.senhaConfirmacao) {
            alert('As senhas são diferente! Revise os campos.');
            return;
        } else {
            setIsLoading(true);
            setTimeout(() => {
                axios.post('http://localhost:8080/users/register', formData)
                .then(response => {
                    console.log("entrou aqui")
                    // Lida com a resposta bem-sucedida, como redirecionar o usuário ou mostrar uma mensagem de sucesso.
                    console.log('Usuário cadastrado com sucesso:', response.data);
                })
                .catch(error => {
                    // Lida com erros na solicitação, como exibir uma mensagem de erro.
                    console.error('Erro ao cadastrar o usuário:', error);
                });
                setIsLoading(false);
                setFormData(initialFormData);  
                alert("Usuário cadastrado com sucesso!")
                navigate(`/Login`);                   
            }, 500)         

        }
    };

    return (
        <>
            <div style={{ display: isLoading ? "flex" : "none" }} className="modal">
                <div className="modal-content">
                    <div className="loader"></div>
                    <div className="modal-text">Loading...</div>
                </div>
            </div>

            <div class="r-container">
                <form onSubmit={handleSubmit}>
                    <span className="title">Cadastro de Usuário</span>
                    <label className="inputText" htmlFor="username">Nome de Usuário:</label>
                    <input

                        type="text"
                        id="username"
                        name="username"
                        value={formData.username}
                        onChange={handleChange}
                    />
                    <label className="inputText" htmlFor="senha">Senha:</label>
                    <input
                        type="password"
                        id="senha"
                        name="senha"
                        value={formData.senha}
                        onChange={handleChange}
                    />
                    <label className="inputText" htmlFor="senhaConfirmacao">Repita a Senha:</label>
                    <input
                        type="password"
                        id="senhaConfirmacao"
                        name="senhaConfirmacao"
                        value={formData.senhaConfirmacao}
                        onChange={handleChange}
                    />
                    <button type="submit" className="button1" onClick={handleSubmit}>Cadastrar</button>
                </form>
                <button className="button2" onClick={handleLogin}><p >Já possui conta? Login.</p></button>
            </div>
        </>
    );
}

export default RegistrationForm;