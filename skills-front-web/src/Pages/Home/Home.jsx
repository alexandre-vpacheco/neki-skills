import React, { useEffect, useState } from "react";
import './Home.css'
import { useNavigate } from "react-router-dom";
import Button from "react-bootstrap/esm/Button";
import SkillModal from "../../Components/SkillModal/SkillModal";

const Home = () => {

    const navigate = useNavigate();

    const [showModal, setShowModal] = useState(false);

    const handleShowModal = () => {
        setShowModal(true);
    };

    const handleCloseModal = () => {
        setShowModal(false);
    };

    const [skills, setSkills] = useState([]);

    const handleSair = () => {
        navigate(`/Login`)
    }

    useEffect(() => {
        async function fetchSkills() {
          try {
            const response = await fetch('http://localhost:8080/user_skills/id_user/skills');
            if (response.status === "Login bem-sucedido!") {
              const data = await response.json();
              setSkills(data);
            } else {
              alert('Falha ao buscar as skills do usuário!');
            }
          } catch (error) {
            alert('Erro ao buscar as skills do usuário!', error);
          }
        }
    
        fetchSkills();
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
                <h2>Lista de Skills do Usuário</h2>
                <ul>
                    {skills.map((skill) => (
                        <li key={skill.id_skill}>{skill.nome}</li>
                    ))}
                </ul>
            </div>
            <div className="r-container-home">
                <div>
                    <Button variant="primary" onClick={handleShowModal}>
                         Skills Disponíveis
                    </Button>
                    <SkillModal show={showModal} handleClose={handleCloseModal} />
                </div>
                <form className="form-home">
                </form>
            </div>
        </>


    )
}

export default Home