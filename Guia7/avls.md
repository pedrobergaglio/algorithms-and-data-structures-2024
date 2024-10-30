
Modulo SIS implementa Sistema
	
	var notas DicLog  <materia, NodoMat>  donde nodomat = struct <notas: Array<ConjLog<alumno>>>
	//donde materia, alumno y nota son int

    pred InvRep(s:Sis){ tiene que tener las restricciones de los valores
        s.materias != null
        and
        para toda materia m, m pertenece a s.materias, entonces 
            s.materias[m].notas != null
            and 
            s.materias[m].notas.length = 11
        and
        paratoda nota n, n entre 0 y 10, entonces
            s.materias[m].notas[n] != null
            and 
            paratoda nota n', n' en rango entoces
                s.materias[m].notas[n] intersección s.materias[m].notas[n'] != vacio
    }

    pred Abs(s: Sis (modulo), s': Sistema (TAD)){ la relación entre el modulo y el TAD

        paratodo materia m, m pertenece s.materias sii m pertenese s'.notas
        and
        paratodo alumno a, paratodo nota n, nota en rango entonces,
            a pertenece s.materias[m].notas[n] sii
                a pertenece a s'.notas[n] and s'.notas[m][a] = n

    }
	
	proc registrarNota(m, a, n) {
		mat = s.materias.obtener(m)  logM
        mat.notas[n].agregar(a)    logN
    } total logM + logN

    proc registrarMateria(inout s: Sis, in m){

        arr = new Array[11]    O(1)
        for i in 0:11{
            c = new congLog()
            arr[i] = c
        }

        mat = struct<notas: arr>
        s.materias.definir(m, mat) O(log M)
    }

    proc notaDeAlumno(m, a, n){
        mat = s.materias.obtener(m)  logM

        for i in 0:11{
            if(a pertenece mat.notas[i]){
                return i
            }
        }
    }


Modulo ConjLogZ implementa Conjunto <Z> 

    var raiz: Nodo
    donde Nodo = <v:int, izq:Nodo, der:Nodo, cantidad:int>

    pred Inv (c) {
        c.esArbol
        and
        c.esAbb estos metodos son por recursión
        and
        cantActualizado(c.raiz)

    }

    proc cantElemsRango( in c:ConjLogZ, in d:int, in h:int){ O(min(n, h))
        acum=0
        it = c.iterador()
        while it.haysiguiente() and it.sig<h {
            if it.sig >= d {
                acum++
            }
            it.avanzar
        }
        return acum
    }

    proc menoresA( in c:Conjunto, in a:int){

    }

    proc menoresA'( in n:Nodo, in a:int){
        
        if n == null {return 0}
        if n.v == a {return tam(n.izq) +1}

        if n.v <a {
            return tam(n.izq) + 1 + menoresA'(n.der, a)
        }

        if n.v > a {
            return menoresA'(n.izq, a)
        }

    }

    proc tam (n:Nodo){ O(n)
        if n == null { return 0}
        este:
            return i + tam(n.izq) + tam(n.der) 
        o este:
            return n.cant
    }

    pred cantActualizado(n:Nodo) {
        n == null or
        (n.cant = 1 +
            ifthenelse (n.izq = null, 0, n.izq.cant) +
            ifthenelse (n.der = null, 0, n.der.cant)
        and
        cantActualizado(n.izq) 
        and
        cantActualizado(n.der) 
        )

    }