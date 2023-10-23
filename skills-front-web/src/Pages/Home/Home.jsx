import React, { useEffect, useState } from "react";
import './Home.css'
import { useNavigate } from "react-router-dom";
import axios from 'axios';

const Home = () => {

    const navigate = useNavigate();

    const handleListarSkills = () => {

    }

    const [skills, setSkills] = useState([]);

    const handleSair = () => {
        navigate(`/Login`)
    }

    useEffect(() => {
        // Faz a requisição para o endpoint da API que retorna as skills
        axios.get('http://localhost:8080/skills')
          .then(response => {
            // Define a lista de skills com os dados recebidos
            setSkills(response.data);
          })
          .catch(error => {
            console.error('Erro ao buscar skills:', error);
          });
      }, []);

    return (
        <>
            <div>
                <header className="header-home">
                    <h2 >Home Page: Cadastrar Skills</h2>
                    <button onClick={handleSair} className="sairButton">Logout</button>
                </header>
            </div>

            <div>
                <h2>Lista de Skills</h2>
                <ul>
                    {skills.map(skill => (
                        <li key={skill.id_skill}>{skill.nome}</li>
                    ))}
                </ul>
            </div>

            <div className="r-container-home">
            <button className="button1" onClick={handleListarSkills}>Listar Skills</button>
                <form className="form-home">

                    
                </form>
            </div>
        </>


    )
}

export default Home