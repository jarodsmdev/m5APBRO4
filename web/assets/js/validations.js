//FUNCIÓN ANÓNIMA AUTOEJECUTABLE DE BOOTSTRAP V5.2.3
// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  'use strict'

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll('.needs-validation')

  // Loop over them and prevent submission
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})();

document.addEventListener("DOMContentLoaded", function(){
  //CAPTURO EL ELEMENTO

  document.addEventListener("keyup", function(){
    let inputDuracion = document.getElementById("duracion");
    validarDuracion(inputDuracion);
    
    let inputAsistentes = document.getElementById("cantAsistentes");
    validarDuracion(inputAsistentes);
  })
  
});

function validarDuracion(elementoHTML){
  const regEx = new RegExp(/^\d+$/);
  
  let duracion = elementoHTML.value;
  
  if(regEx.test(duracion)){
      
  }else{
      elementoHTML.value = "";
  }
  
}

