const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const cors = require('cors');

const app = express();
const port = 3001;



app.use(bodyParser.json());
app.use(cors());

const questionsFilePath = './questions.json';

// Endpoint para obtener todas las preguntas (GET)
app.get('/questions/', (req, res) => {
  fs.readFile(questionsFilePath, 'utf8', (err, data) => {
    if (err) {
      res.status(500).json({ error: 'No se pudo leer el archivo de preguntas.' });
      return;
    }

    try {
      const questions = JSON.parse(data);
      res.json(questions);
    } catch (parseError) {
      res.status(500).json({ error: 'Error al analizar el archivo JSON.' });
    }
  });
});

// Endpoint para agregar una nueva pregunta (POST)
app.post('/questions/', (req, res) => {
  const newQuestion = req.body;
  console.log("el body recibido")
  console.log(newQuestion)
  fs.readFile(questionsFilePath, 'utf8', (err, data) => {
    if (err) {
      res.status(500).json({ error: 'No se pudo leer el archivo de preguntas.' });
      return;
    }

    try {

      const questions = JSON.parse(data);

      questions.push(newQuestion);

      fs.writeFile(questionsFilePath, JSON.stringify(questions, null, 2), (err) => {
        if (err) {
          res.status(500).json({ error: 'No se pudo escribir en el archivo de preguntas.' });
          return;
        }

        res.json(newQuestion);
      });
    } catch (parseError) {
      res.status(500).json({ error: 'Error al analizar el archivo JSON.' });
    }
  });
});

app.put('/questions/:id', (req, res) => {
  const questionId = parseInt(req.params.id);
  const updatedQuestion = req.body;
  console.log(questionId)
  fs.readFile(questionsFilePath, 'utf8', (err, data) => {
    if (err) {
      res.status(500).json({ error: 'No se pudo leer el archivo de preguntas.' });
      return;
    }


    try {
      const questions = JSON.parse(data);
      const existingQuestionIndex = questions.findIndex((question) => question.id == questionId);

      if (existingQuestionIndex === -1) {
        res.status(404).json({ error: 'La pregunta no fue encontrada.' });
        return;
      }

      questions[existingQuestionIndex] = { ...questions[existingQuestionIndex], ...updatedQuestion };

      fs.writeFile(questionsFilePath, JSON.stringify(questions, null, 2), (err) => {
        if (err) {
          res.status(500).json({ error: 'No se pudo escribir en el archivo de preguntas.' });
          return;
        }

        res.json(questions[existingQuestionIndex]);
      });
    } catch (parseError) {
      res.status(500).json({ error: 'Error al analizar el archivo JSON.' });
    }
  });
});

// Endpoint para eliminar una pregunta (DELETE)
app.delete('/questions/:id', (req, res) => {
  const questionId = req.params.id;
  console.log(questionId)
  fs.readFile(questionsFilePath, 'utf8', (err, data) => {
    if (err) {
      res.status(500).json({ error: 'No se pudo leer el archivo de preguntas.' });
      return;
    }

    try {
      const questions = JSON.parse(data);
      console.log(questions)
      console.log(questionId)
      const existingQuestionIndex = questions.findIndex((question) => question.id == questionId);
      console.log(existingQuestionIndex)
      if (existingQuestionIndex === -1) {
        res.status(404).json({ error: 'La pregunta no fue encontrada.' });
        return;
      }

      const deletedQuestion = questions.splice(existingQuestionIndex, 1);

      fs.writeFile(questionsFilePath, JSON.stringify(questions, null, 2), (err) => {
        if (err) {
          res.status(500).json({ error: 'No se pudo escribir en el archivo de preguntas.' });
          return;
        }

        res.json(deletedQuestion[0]);
      });
    } catch (parseError) {
      res.status(500).json({ error: 'Error al analizar el archivo JSON.' });
    }
  });
});

app.listen(port, () => {
  console.log(`Servidor Node.js en funcionamiento en el puerto ${port}`);
});
