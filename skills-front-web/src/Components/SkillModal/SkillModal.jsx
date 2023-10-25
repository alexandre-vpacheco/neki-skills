import React, { useState, useEffect } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import './SkillModal.css'
import axios from 'axios';

export default function SkillModal({ show, handleClose }) {

    const [skills, setSkills] = useState([]);

    useEffect((show) => {
        axios.get('http://localhost:8080/skills').then((response) => {
          setSkills(response.data);
        });
      }, [show]);

    return (
        <Modal className='modal-container' show={show} onHide={handleClose}>
            <Modal.Title className='text'>Lista de Skills</Modal.Title>
            <Modal.Body className='text'>
                <ol>
                    {skills.map((skill) => (
                        <li className='text' key={skill.id_skill}>{skill.imagem_url}{skill.nome_skill}{skill.descricao}</li>
                    ))}
                </ol>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>
                    Fechar
                </Button>
            </Modal.Footer>
        </Modal>
    );
}