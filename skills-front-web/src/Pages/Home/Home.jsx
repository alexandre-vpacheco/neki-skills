import React, { useEffect, useState } from "react";
import './Home.css'
import { useNavigate } from "react-router-dom";
import axios from 'axios';
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
    return (
        <>
            <div>
                <header className="header-home">
                    <h2 >Home Page: Cadastrar Skills</h2>
                    <button onClick={handleSair} className="sairButton">Logout</button>
                </header>
            </div>
            <div className="r-container-home">
                <div>
                    <Button variant="primary" onClick={handleShowModal}>
                    Listar Skills
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