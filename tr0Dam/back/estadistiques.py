import pandas as pd

def show_stats(df):
    #print(df.head)

    tiempo_promedio = df["tiempo"].mean()
    porcentaje_correcto = (df["correcta"].sum() / len(df)) *100

    print(f"Promedio tiempo de respuestas: {tiempo_promedio:.2f} segundos ")

    print(f"Porcentaje de respuestas correctas {porcentaje_correcto:.2f}%")
    
    resultados_pregunta = df.groupby("indice_pregunta").agg(
        tiempo_promedio=("tiempo", "mean"),
        porcentaje_correcto=("correcta","mean")
    )

    resultados_pregunta = resultados_pregunta.rename(columns={
        "tiempo_promedio":"Promedio de tiempo (segundos)",
        "porcentaje_correcto": "Porcentaje de respuestas corectas (%)"
    })

    #print(resultados_pregunta)


df = pd.read_json("respuestas.json")

show_stats(df)

resultado_inferior_5 = df[df["tiempo"]<5]

if resultado_inferior_5.empty:
    print("No hay resultads menores a 5 segundos.")
else:
    print("Resultado inferior a 5 segundos:")
    print(resultado_inferior_5)

df = df[df['tiempo'] >= 5]

#show_stats(df)

aciertostotal = df[df["correcta"] == True]
masacierto = aciertostotal["indice_pregunta"].value_counts().idxmax()

fallostotal = df[df["correcta"] == False]
masfallos = fallostotal["indice_pregunta"].value_counts().idxmax()

print("Respuesta con mas aciertos:", masacierto)
print("Respuesta con mas fallos: ", masfallos)