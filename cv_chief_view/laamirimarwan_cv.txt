const arrow = [
  [
    { qua: 'What is a correct syntax to output "Hello World" in Java?', id: 1, label: "printf(hello world)", correct: 2 },
    {
      id: 3,
      label: "echohello world",
    },
    {
      id: 2,
      label: "System.out.println(hello world)",
    },
    {
      id: 4,
      label: "console.log(hello world)",
    },
  ],
  [
    { qua: "Which data type is used to create a variable that should store text?", id: 5, label: "A.txt", correct: 6 },
    {
      id: 6,
      label: "String",
    },
    {
      id: 7,
      label: "string",
    },
    {
      id: 8,
      label: "txt",
    },
  ],
  [
    { qua: "Which method can be used to find the length of a string A?", id: 9, label: "sizeof()", correct: 11 },
    {
      id: 10,
      label: "lenght()",
    },
    {
      id: 11,
      label: "A.lenght()",
    },
    {
      id: 12,
      label: "A.size",
    },
  ],
  [
    { qua: "To declare an array in Java, define the variable type with:", id: 13, label: "//", correct: 16 },
    {
      id: 14,
      label: "{}",
    },
    {
      id: 15,
      label:"()",
    },
    {
      id: 16,
      label: "[]",
    },
  ],
  [
    { qua: "Array indexes start with:", id: 17, label: "1", correct: 18 },
    {
      id: 18,
      label: "0",
    },
    {
      id: 19,
      label: "with any values u wanna be ",
    },
    {
      id: 20,
      label: "no one of them are correct",
    },
  ],
  [
    { qua: "how to create a new object", id: 21, label: "new name of object", correct: 23 },
    {
      id: 22,
      label: "new name of variable",
    },
    {
      id: 23,
      label: "nameobject namevariable=new nameobject()",
    },
    {
      id: 24,
      label: "nameobject namevariable=new nameobject",
    },
],
  [
    { qua: " what s my name ", id: 25, label: "ouss", correct: 28 },
    {
      id: 26,
      label: "ousss",
    },
    {
      id: 27,
      label: "oussama",
    },
    {
      id: 28,
      label: "rahmoun oussama",
    },
  ],
];

const quationTag = document.querySelector(".a4");
const p = document.querySelector("h2");

const submit = document.querySelector(".submit");
let i = 0;
let quationChoose = arrow[i];
let aa1 = [];
let x = 0;
window.addEventListener("DOMContentLoaded", () => {
  bad(quationTag);

  i++;
});

submit.addEventListener("click", () => {
  const inputs = document.querySelectorAll(".input");
  inputs.forEach((input) => {
    if (input.checked && input.id == quationChoose[0].correct) {
      x++;
    }
  });

  quationChoose = arrow[i++];
  bad(quationTag);
});

function add(t11) {
  return `
  <div class="input-container">
    <input type="checkbox"  id="${t11.id} "  class='input'  /><label for="${t11.id}"> ${t11.label}</label>
  </div>`;
}

function bad(ba) {
  if (i < arrow.length + 1) {
    quationChoose.forEach((s) => {
      aa1 += add(s);
    });
  }
  if (i == arrow.length + 1) {
    p.textContent = x + "/" + arrow.length;

    ba.innerHTML = "";
    submit.value = "replay";
    i = 0;
    quationChoose = arrow[i];
  } else {
    submit.value = "Submit";
    p.textContent = quationChoose[0].qua;
    ba.innerHTML = aa1;
    aa1 = [];
  }
}
