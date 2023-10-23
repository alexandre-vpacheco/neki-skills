import React, { useState } from "react";
import './Cadastro.css'
import { useNavigate } from "react-router-dom";
import { RequestAPI } from "../../Services/Api";
import { toast } from "react-toastify";

const Cadastro = () => {
  

    const [username, setUsername] = useState("");
    const [senha, setSenha] = useState("");
    const [senhaConf, setSenhaConf] = useState("");

    const [isLoading, setIsLoading] = useState(false);

    const [hidePass, setHidePass] = useState(false);

    const navigate = useNavigate();

    const handleError1 = (error) => {
        if (error.response.data.message == "Error: Username is already taken!") {
          toast.error(`Erro no cadastro, nome de usuário já em uso!`);
        }
      };

    const handleCadastrar = async () => {
      console.log("entrou aqui")
        if (
            username != "" &&
            senha != null &&
            "" != senhaConf
          ) {
            if (senha == senhaConf) {
              setIsLoading(true);
              console.log("veio aqui 1 ", data);
              let msg = {
                username: username,
                senha: senha,
              };
              console.log("veio aqui 2", data);
              try {
                console.log("veio aqui 3", data);
                console.log(msg);
                const saveCliente = await RequestAPI.post(`/users/register`, msg);
                if (saveCliente.data) {
                  setIsLoading(false);
                  toast.success(`Usuário salvo com sucesso!`);
                  navigate("/Login");
                } else {
                  toast.error(`Erro no save de cliente.`);
                  setIsLoading(false);
                  console.log("veio aqui ", data);
                }
              } catch (error) {
                setIsLoading(false);
                handleError1(error);
      
                console.log("Erro ao salvar cliente.", error);
              }
            } else {
              setIsLoading(false);
              toast.error("Senhas não conferem!");
            }
          } else {
            setIsLoading(false);
            toast.error("Dados inválidos.");
          }

    };
 
    const handleLogin = () => {
        navigate(`/Login`);
    }

    return (
        <>
            <div style={{ display: isLoading ? "flex" : "none" }} className="modal">
                <div className="modal-content">
                    <div className="loader"></div>
                    <div className="modal-text">Loading...</div>
                </div>
            </div>

            <div className="r-container">
                <span className="title">Sistema Skill: Cadastro</span>
                <form >
                    <input value={username}
                        type = "text"
                        placeholder="Usuário"
                        onChange={(e) => {
                            setUsername(e.target.value);
                        }} />

                    <input value={senha}
                        type = {hidePass ? "text" : "password"}
                        placeholder="Senha"
                        onChange={(e) => {
                            setSenha(e.target.value);
                        }}
                    />

                    <input type = {hidePass ? "text" : "password"}
                        placeholder="Repita a senha"
                        value={senhaConf}
                        onChange={(e) => {
                            setSenhaConf(e.target.value);
                        }} />

                    <button className="button1" onClick={handleCadastrar}>Cadastrar</button>
                </form>
                <button className="button2" onClick={handleLogin}><p >Já possui conta? Login.</p></button>
            </div>
        </>

    )
}

export default Cadastro